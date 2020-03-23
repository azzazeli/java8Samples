package com.alexm.cleancode.args2;

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

    public Args(String schema, String[] args) throws ArgsException {
        this.schema = schema;
        this.argsList = Arrays.asList(args);
        this.valid = parse();
    }

    private boolean parse() throws ArgsException {
        if (schema.length() == 0 && argsList.isEmpty()) {
            return true;
        }
        parseSchema();
        parseArguments();
        return valid;
    }

    private void parseSchema() throws ArgsException {
        for (String element : schema.split(",")) {
            if (!element.trim().isEmpty()) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws ArgsException {
        final char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);

        if (element.length() == 1) {
            argMarshalers.put(elementId, new BooleanArgumentMarshaller());
        } else if (elementTail.contains("*")) {
            argMarshalers.put(elementId, new StringArgumentMarshaller());
        } else if (element.contains("#")) {
            argMarshalers.put(elementId, new IntegerArgumentMarshaller());
        }
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId)) {
            throw new ArgsException("Bad character:" + elementId + " in Args format:" + schema);
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

}
