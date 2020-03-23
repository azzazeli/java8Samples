package com.alexm.cleancode.args2;

import java.text.ParseException;
import java.util.*;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.*;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class Args {
    private String schema;
    private List<String> argsList;
    private Iterator<String> currentArgIterator;
    private boolean valid;
    private Map<Character, ArgumentMarshaler> argMarshalers = new HashMap<>();
    private Set<Character> argsFound = new TreeSet<>();

    public Args(String schema, String[] args) throws ParseException, ArgsException {
        this.schema = schema;
        this.argsList = Arrays.asList(args);
        this.valid = parse();
    }

    private boolean parse() throws ParseException, ArgsException {
        if (schema.length() == 0 && argsList.isEmpty()) {
            return true;
        }
        parseSchema();
        parseArguments();
        return valid;
    }

    private void parseSchema() throws ParseException {
        for (String element : schema.split(",")) {
            if (!element.trim().isEmpty()) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws ParseException {
        final char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);

        if (element.length() == 1) {
            argMarshalers.put(elementId, new ArgumentMarshaler.BooleanArgumentMarshaller());
        } else if (elementTail.contains("*")) {
            argMarshalers.put(elementId, new ArgumentMarshaler.StringArgumentMarshaller());
        } else if (element.contains("#")) {
            argMarshalers.put(elementId, new ArgumentMarshaler.IntegerArgumentMarshaller());
        }
    }

    private void validateSchemaElementId(char elementId) throws ParseException {
        if (!Character.isLetter(elementId)) {
            throw new ParseException("Bad character:" + elementId + " in Args format:" + schema, 0);
        }
    }

    private void parseArguments() throws ArgsException {
        for(currentArgIterator = argsList.iterator(); currentArgIterator.hasNext();) {
            parseArgument(currentArgIterator.next());
        }
    }

    private void parseArgument(String arg) throws ArgsException {
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) throws ArgsException {
        for (int i = 1; i < arg.length(); i++) {
            parseElement(arg.charAt(i));
        }
    }

    private void parseElement(char argChar) throws ArgsException {
        final ArgumentMarshaler am = argMarshalers.get(argChar);
        if (am == null) {
            throw new ArgsException(UNEXPECTED_ARGUMENT, argChar);
        }
        try {
            am.set(currentArgIterator);
            argsFound.add(argChar);
        } catch (ArgsException e) {
            valid = false;
            e.setErrorArgument(argChar);
            throw e;
        }
    }

    public String usage() {
        if (!schema.isEmpty()) {
            return "-[" + schema + "]";
        }
        return "";
    }

    public boolean getBoolean(char argChar) {
        final ArgumentMarshaler am = argMarshalers.get(argChar);
        return am != null && (Boolean) am.get();
    }

    public String getString(char argChar) {
        final ArgumentMarshaler am = argMarshalers.get(argChar);
        return am == null ? "" : (String) am.get();
    }

    public int getInteger(char argChar) {
        final ArgumentMarshaler am = argMarshalers.get(argChar);
        return am == null ? 0 : (Integer) am.get();
    }

    public int cardinality() {
        return argsFound.size();
    }

    public boolean isValid() {
        return valid;
    }

    private interface ArgumentMarshaler {
        void set(Iterator<String> currentArgument) throws ArgsException;
        Object get();

        class BooleanArgumentMarshaller implements ArgumentMarshaler {
            private boolean booleanValue;

            @Override
            public void set(Iterator<String> currentArgument) throws ArgsException {
                this.booleanValue = true;
            }

            @Override
            public Object get() {
                return booleanValue;
            }
        }

        class StringArgumentMarshaller implements ArgumentMarshaler {
            private String stringValue = "";

            @Override
            public void set(Iterator<String> currentArgument) throws ArgsException {
                try {
                    stringValue = currentArgument.next();
                } catch (NoSuchElementException e) {
                    throw new ArgsException(MISSING_STRING);
                }
            }

            @Override
            public Object get() {
                return stringValue == null ? "" : stringValue;
            }
        }

        class IntegerArgumentMarshaller implements ArgumentMarshaler {
            private int integerValue;

            @Override
            public void set(Iterator<String> currentArgument) throws ArgsException {
                String parameter = null;
                try {
                    parameter = currentArgument.next();
                    integerValue = Integer.parseInt(parameter);
                } catch (NoSuchElementException e) {
                    throw new ArgsException(MISSING_INTEGER);
                } catch (NumberFormatException e) {
                    throw new ArgsException(INVALID_INTEGER, parameter);
                }
            }

            @Override
            public Object get() {
                return integerValue;
            }
        }
    }

}
