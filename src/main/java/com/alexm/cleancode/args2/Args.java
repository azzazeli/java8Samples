package com.alexm.cleancode.args2;

import java.text.ParseException;
import java.util.*;

import static com.alexm.cleancode.args2.Args.ErrorCode.*;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class Args {
    private String schema;
    private List<String> argsList;
    private Iterator<String> currentArgIterator;
    private boolean valid;
    private Set<Character> unexpectedArguments = new TreeSet<>();
    private Map<Character, ArgumentMarshaler> argMarshalers = new HashMap<>();
    private Set<Character> argsFound = new TreeSet<>();
    private ErrorCode errorCode = OK;
    private char errorArgument = '\0';
    private String errorParameter;

    public enum ErrorCode {
        MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, OK
    }

    public Args(String schema, String[] args) throws ParseException {
        this.schema = schema;
        this.argsList = Arrays.asList(args);
        this.valid = parse();
    }

    private boolean parse() throws ParseException {
        if (schema.length() == 0 && argsList.size() == 0) {
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

        if (isaBooleanSchemaElement(element)) {
            parseBooleanSchemaElement(elementId);
        } else if (isStringSchemaElement(elementTail)) {
            parseStringSchemaElement(elementId);
        } else if (isIntegerSchemaElement(elementTail)) {
            parseIntegerSchemaElement(elementId);
        }
    }

    private void parseIntegerSchemaElement(char elementId) {
        argMarshalers.put(elementId, new ArgumentMarshaler.IntegerArgumentMarshaller());
    }

    private void parseBooleanSchemaElement(char elementId) {
        argMarshalers.put(elementId, new ArgumentMarshaler.BooleanArgumentMarshaller());
    }

    private void parseStringSchemaElement(char elementId) {
        argMarshalers.put(elementId, new ArgumentMarshaler.StringArgumentMarshaller());
    }

    private boolean isIntegerSchemaElement(String elementId) {
        return elementId.contains("#");
    }

    private boolean isStringSchemaElement(String elementTail) {
        return elementTail.contains("*");
    }

    private boolean isaBooleanSchemaElement(String element) {
        return element.length() == 1;
    }

    private void validateSchemaElementId(char elementId) throws ParseException {
        if (!Character.isLetter(elementId)) {
            throw new ParseException("Bad character:" + elementId + " in Args format:" + schema, 0);
        }
    }

    private void parseArguments() {
        for(currentArgIterator = argsList.iterator(); currentArgIterator.hasNext();) {
            parseArgument(currentArgIterator.next());
        }
    }

    private void parseArgument(String arg) {
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) {
        for (int i = 1; i < arg.length(); i++) {
            parseElement(arg.charAt(i));
        }
    }

    private void parseElement(char argChar) {
        if (setArgument(argChar)) {
            argsFound.add(argChar);
        } else {
            unexpectedArguments.add(argChar);
            valid = false;
        }
    }

    private boolean setArgument(char argChar) {
        final ArgumentMarshaler am = argMarshalers.get(argChar);
        if (am == null) {
            return false;
        }
        try {
            if (am instanceof ArgumentMarshaler.BooleanArgumentMarshaller) {
                setBooleanArgument(am);
            } else if (am instanceof ArgumentMarshaler.StringArgumentMarshaller) {
                setStringArgument(am);
            } else if (am instanceof ArgumentMarshaler.IntegerArgumentMarshaller) {
                setIntegerArgument(am);
            }
        } catch (ArgsException e) {
            valid = false;
            this.errorArgument = argChar;
        }
        return true;
    }

    private void setIntegerArgument(ArgumentMarshaler am) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgIterator.next();
            am.set(parameter);
        } catch (NoSuchElementException e) {
            errorCode = MISSING_INTEGER;
            throw new ArgsException();
        } catch (ArgsException e) {
            errorParameter = parameter;
            errorCode = INVALID_INTEGER;
            throw e;
        }
    }

    private void setStringArgument(ArgumentMarshaler am) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgIterator.next();
            am.set(parameter);
        } catch (NoSuchElementException e) {
            errorCode = MISSING_STRING;
            throw new ArgsException();
        }
    }

    private void setBooleanArgument(ArgumentMarshaler am) throws ArgsException {
        am.set("true");
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

    public String getErrorMessage() throws ArgsException {
        if (!unexpectedArguments.isEmpty()) {
            return unexpectedArgumentMessage();
        } else {
            switch (errorCode) {
                case MISSING_STRING:
                    return String.format("Could not find string parameter for: -%c.", errorArgument);
                case MISSING_INTEGER:
                    return String.format("Could not find integer parameter for: -%c", errorArgument);
                case INVALID_INTEGER:
                    return String.format("Invalid value:%s provided for integer argument:-%c", errorParameter, errorArgument);
                case OK:
                    throw new ArgsException("TILT: Should not get here");
            }
        }
        return "";
    }

    private String unexpectedArgumentMessage() {
        StringBuilder sb = new StringBuilder("Argument (s) -");
        for (Character unexpectedArgument : unexpectedArguments) {
            sb.append(" ");
            sb.append(unexpectedArgument);
        }
        sb.append(" unexpected.");
        return sb.toString();
    }

    public int cardinality() {
        return argsFound.size();
    }

    public boolean isValid() {
        return valid;
    }

    private abstract static class ArgumentMarshaler {
        public abstract void set(String value) throws ArgsException;
        public abstract Object get();

        private static class BooleanArgumentMarshaller extends ArgumentMarshaler {
            private boolean booleanValue;

            @Override
            public void set(String value) {
                this.booleanValue = true;
            }

            @Override
            public Object get() {
                return booleanValue;
            }
        }

        private static class StringArgumentMarshaller extends ArgumentMarshaler {
            private String stringValue = "";

            @Override
            public void set(String value) {
                if (value != null) {
                    this.stringValue = value;
                }
            }

            @Override
            public Object get() {
                return stringValue == null ? "" : stringValue;
            }
        }

        private static class IntegerArgumentMarshaller extends ArgumentMarshaler {
            private int integerValue;

            @Override
            public void set(String value) throws ArgsException {
                try {
                    this.integerValue = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new ArgsException(e.getMessage());
                }
            }

            @Override
            public Object get() {
                return integerValue;
            }
        }
    }

    public static class ArgsException extends Exception {

        public ArgsException(String s) {
            super(s);
        }

        public ArgsException() {
            super();
        }
    }
}
