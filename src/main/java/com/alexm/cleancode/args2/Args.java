package com.alexm.cleancode.args2;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static com.alexm.cleancode.args2.Args.ErrorCode.*;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class Args {
    private String schema;
    private String[] args;
    private boolean valid;
    private Set<Character> unexpectedArguments = new TreeSet<>();
    private Map<Character, ArgumentMarshaler> booleanArgs = new HashMap<>();
    private Map<Character, ArgumentMarshaler> stringArgs = new HashMap<>();
    private Set<Character> argsFound = new TreeSet<>();
    private int currentArgument = 0;
    private ErrorCode errorCode = OK;
    private char errorArgument = '\0';
    private String errorParameter;
    private Map<Character, ArgumentMarshaler> intArgs = new HashMap<>();

    public enum ErrorCode {
        MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, OK
    }

    public Args(String schema, String[] args) throws ParseException {
        this.schema = schema;
        this.args = args;
        this.valid = parse();
    }

    private boolean parse() throws ParseException {
        if (schema.length() == 0 && args.length == 0) {
            return true;
        }
        parseSchema();
        parseArguments();
        return valid;
    }

    private void parseSchema() throws ParseException {
        for (String element: schema.split(",")) {
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
            parseBooleanSchemaElement(element);
        } else if (isStringSchemaElement(elementTail)) {
            parseStringSchemaElement(elementId);
        } else if (isIntegerSchemaElement(elementTail)) {
            parseIntegerSchemaElement(elementId);
        }
    }

    private void parseIntegerSchemaElement(char elementId) {
        intArgs.put(elementId, new ArgumentMarshaler.IntegerArgumentMarshaller());
    }

    private boolean isIntegerSchemaElement(String elementId) {
        return elementId.contains("#");
    }

    private void parseStringSchemaElement(char elementId) {
        stringArgs.put(elementId, new ArgumentMarshaler.StringArgumentMarshaller());
    }

    private boolean isStringSchemaElement(String elementTail) {
        return elementTail.contains("*");
    }

    private boolean isaBooleanSchemaElement(String element) {
        return element.length() == 1;
    }

    private void parseBooleanSchemaElement(String element) {
        final char c = element.charAt(0);
        if (Character.isLetter(c)) {
            booleanArgs.put(c, new ArgumentMarshaler.BooleanArgumentMarshaller());
        }
    }

    private void validateSchemaElementId(char elementId) throws ParseException {
            if (!Character.isLetter(elementId)) {
            throw new ParseException("Bad character:" + elementId + " in Args format:" + schema, 0);
        }
    }

    private void parseArguments() {
        for(currentArgument = 0; currentArgument < args.length; currentArgument++) {
            parseArgument(args[currentArgument]);
        }
    }

    private void parseArgument(String arg) {
        if (arg.startsWith("-")) {
            parseElements(arg);
        }
    }

    private void parseElements(String arg) {
        for(int i = 1; i < arg.length(); i++) {
            parseElement(arg.charAt(i));
        }
    }

    private void parseElement(char argChar) {
        if(setArgument(argChar)) {
            argsFound.add(argChar);
        } else {
            unexpectedArguments.add(argChar);
            valid = false;
        }
    }

    private boolean setArgument(char argChar) {
        boolean set = false;
        if (isBoolean(argChar)) {
            setBooleanArgument(argChar, true);
            set = true;
        } else if(isString(argChar)) {
            setStringArgument(argChar);
            set = true;
        }
        else if (isInteger(argChar)) {
            setIntegerArgument(argChar);
            set = true;
        }
        return set;
    }

    private void setIntegerArgument(char argChar) {
        currentArgument++;
        String parameter = null;
        try {
            parameter = args[currentArgument];
            intArgs.get(argChar).setIntegerValue(Integer.parseInt(parameter));
        } catch (IndexOutOfBoundsException e) {
            valid = false;
            errorArgument = argChar;
            errorCode = MISSING_INTEGER;
        } catch (NumberFormatException e) {
            valid = false;
            errorArgument = argChar;
            errorParameter = parameter;
            errorCode = INVALID_INTEGER;
        }
    }

    private boolean isInteger(char argChar) {
        return intArgs.containsKey(argChar);
    }

    private void setStringArgument(char argChar) {
        currentArgument++;
        try {
            stringArgs.get(argChar).setStringValue(args[currentArgument]);
        } catch (ArrayIndexOutOfBoundsException e) {
            valid = false;
            errorArgument = argChar;
            errorCode = MISSING_STRING;
//            throw new ArgsException();
        }
    }

    private boolean isString(char argChar) {
        return stringArgs.containsKey(argChar);
    }

    private void setBooleanArgument(char argChar, boolean b) {
        this.booleanArgs.get(argChar).setBooleanValue(b);
    }

    private boolean isBoolean(char argChar) {
        return booleanArgs.containsKey(argChar);
    }

    public String usage() {
        if (!schema.isEmpty()) {
            return "-[" + schema + "]";
        }
        return "";
    }

    public boolean getBoolean(char argChar) {
        final ArgumentMarshaler am = booleanArgs.get(argChar);
        return am != null && am.getBooleanValue();
    }

    public String getString(char argChar) {
        final ArgumentMarshaler am = stringArgs.get(argChar);
        return am == null ? "" : am.getStringValue();
    }

    public int getInteger(char argChar) {
        final ArgumentMarshaler am = intArgs.get(argChar);
        return am == null ? 0 : am.getIntegerValue();
    }

    public String getErrorMessage() throws Exception {
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
                    throw new Exception("TILT: Should not get here");
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

    private static class ArgumentMarshaler {
        private boolean booleanValue;
        private String stringValue;
        private int integerValue;

        public boolean getBooleanValue() {
            return booleanValue;
        }

        public void setBooleanValue(boolean booleanValue) {
            this.booleanValue = booleanValue;
        }

        public String getStringValue() {
            return stringValue == null ? "" : stringValue;
        }

        public void setStringValue(String stringValue) {
            this.stringValue = stringValue;
        }

        public void setIntegerValue(int value) {
            this.integerValue = value;
        }

        public int getIntegerValue() {
            return integerValue;
        }

        private static class BooleanArgumentMarshaller extends ArgumentMarshaler {

        }

        private static class StringArgumentMarshaller extends ArgumentMarshaler {

        }

        private static class IntegerArgumentMarshaller extends ArgumentMarshaler {

        }
    }

    private class ArgsException extends Throwable {

    }
}
