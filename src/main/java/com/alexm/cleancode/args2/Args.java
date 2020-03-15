package com.alexm.cleancode.args2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
public class Args {
    private String schema;
    private String[] args;
    private boolean valid;
    private Set<Character> unexpectedArguments = new TreeSet<>();
    private Map<Character, Boolean> booleanArgs = new HashMap<>();
    private int numberOfArguments = 0;

    public Args(String schema, String[] args) {
        this.schema = schema;
        this.args = args;
        this.valid = parse();
    }

    private boolean parse() {
        if (schema.length() == 0 && args.length == 0) {
            return true;
        }
        parseSchema();
        parseArguments();
        return unexpectedArguments.isEmpty();
    }

    private void parseSchema() {
        for (String element: schema.split(",")) {
            parseSchemaElement(element);
        }
    }

    private void parseSchemaElement(String element) {
        if (element.length() == 1) {
            parseBooleanSchemaElement(element);
        }
    }

    private void parseBooleanSchemaElement(String element) {
        final char c = element.charAt(0);
        if (Character.isLetter(c)) {
            booleanArgs.put(c, false);
        }
    }

    private void parseArguments() {
        for(String arg: args) {
            parseArgument(arg);
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
        if (isBoolean(argChar)) {
            numberOfArguments++;
            setBooleanArgument(argChar, true);
        } else {
            unexpectedArguments.add(argChar);
        }
    }

    private void setBooleanArgument(char argChar, boolean b) {
        this.booleanArgs.put(argChar, b);
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

    public boolean getBoolean(char arg) {
        return booleanArgs.get(arg);
    }

    public String getErrorMessage() {
        if (!unexpectedArguments.isEmpty()) {
            return unexpectedArgumentMessage();
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

    public int getInteger(char arg) {
        return 0;
    }

    public String getString(char arg) {
        return null;
    }

    public int cardinality() {
        return numberOfArguments;
    }

    public boolean isValid() {
        return valid;
    }
}
