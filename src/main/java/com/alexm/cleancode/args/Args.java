package com.alexm.cleancode.args;

import java.util.*;

import static com.alexm.cleancode.args.ArgsException.ErrorCode.*;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class Args {
    private Map<Character, ArgumentMarshaler> marshalers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;


    public Args(String schema, String[] args) throws ArgsException {
        marshalers = new HashMap<>();
        argsFound = new HashSet<>();

        parseSchema(schema);
        parseArgumentString(Arrays.asList(args));
    }

    private void parseSchema(String schema) throws ArgsException {
        for (String element : schema.split(",")) {
            if (element.length() > 0) {
                parseSchemaElement(element.trim());
            }
        }
    }

    private void parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);
        if(elementTail.length() == 0) {
            marshalers.put(elementId, new BooleanArgumentMarshaler());
        }
        else if (elementTail.equals("*")) {
            marshalers.put(elementId, new StringArgumentMarshaller());
        }
        else if (elementTail.equals("#")) {
            marshalers.put(elementId, new IntegerArgumentMarshaller());
        }
        else if (elementTail.equals("##")) {
            marshalers.put(elementId, new DoubleArgumentMarshaller());
        }
        else if (elementTail.equals("[*]")) {
            marshalers.put(elementId, new StringArrayArgumentMarshaler());
        }
        else throw new ArgsException(INVALID_ARGUMENT_FORMAT, elementId, elementTail);
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId)) {
            throw new ArgsException(INVALID_ARGUMENT_NAME, elementId, null);
        }
    }

    private void parseArgumentString(List<String> argList) throws ArgsException {
        for (currentArgument = argList.listIterator(); currentArgument.hasNext();) {
            final String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException {
        for (int i = 0; i < argChars.length(); i++) {
            parseArgumentCharacter(argChars.charAt(i));
        }
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException {
        final ArgumentMarshaler marshaler = marshalers.get(argChar);
        if (marshaler == null) {
            throw new ArgsException(UNEXPECTED_ARGUMENT, argChar, null);
        }
        else {
            argsFound.add(argChar);
            try {
                marshaler.set(currentArgument);
            } catch (ArgsException e) {
                e.setErrorArgumentId(argChar);
                throw e;
            }
        }
    }


    public boolean has(char arg) {
        return argsFound.contains(arg);
    }
    public boolean getBoolean(char arg) {
        return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public int getInt(char arg) {
        return IntegerArgumentMarshaller.getValue(marshalers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarshaller.getValue(marshalers.get(arg));
    }

    public Double getDouble(char arg) {
        return DoubleArgumentMarshaller.getVAlue(marshalers.get(arg));
    }

    public String[] getStringArray(char arg) {
        return StringArrayArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public int nextArgument() {
        return currentArgument.nextIndex();
    }
}
