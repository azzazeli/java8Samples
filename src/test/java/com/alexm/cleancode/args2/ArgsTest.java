package com.alexm.cleancode.args2;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.*;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
class ArgsTest {

    @Test
    void noSchemaNoArguments() throws ParseException, ArgsException {
        Args args = new Args("", new String[0]);
        assertThat(args.cardinality(), is(eq(0)));
    }

    @Test
    void noSchemaOneArgument() throws Exception {
        final ArgsException argsException = assertThrows(ArgsException.class, () ->  new Args("", new String[]{"-x"}));
        assertEquals("Unexpected argument:x found.", argsException.getErrorMessage());
    }

    @Test
    void noSchemaMultipleArguments() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("", new String[]{"-x", "-y"}));
        assertEquals("Unexpected argument:x found.", argsException.getErrorMessage());
    }

    @Test
    void spaceInSchema() throws ParseException, ArgsException {
        final Args args = new Args("k,     p,          d", new String[]{"-kpd"});
        assertAll("space",
                () -> assertEquals(3, args.cardinality()));
    }

    @Test
    void nonLetterSchema() throws ParseException {
        final ParseException ex = assertThrows(ParseException.class,
                () -> new Args("*333", new String[]{}));
        assertThat(ex.getMessage(), is("Bad character:* in Args format:*333"));
    }

    @Test
    void invalidArgumentFormat() throws ParseException, ArgsException {
        Args args = new Args("t%", new String[]{});
        //todo: implement me
    }

    @Test
    void simpleBooleanPresent() throws ParseException, ArgsException {
        Args args = new Args("x", new String[]{"-x"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertTrue(args.getBoolean('x'))
        );
    }

    @Test
    void booleanAndStringPresent() throws ParseException, ArgsException {
        Args args = new Args("l,x*", new String[]{"-l", "-x", "test"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertEquals("test", args.getString('x')),
                () -> assertTrue(args.getBoolean('l'))
        );
    }

    @Test
    void simpleStringPresent() throws ParseException, ArgsException {
        Args args = new Args("x*", new String[]{"-x",  "test"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertEquals("test", args.getString('x'))
        );
    }

    @Test
    void simpleIntegerPresent() throws ParseException, ArgsException {
        Integer sampleInt = 33;
        final Args args = new Args("d#", new String[]{"-d", sampleInt.toString()});
        assertAll("get integer",
                () -> assertEquals(1, args.cardinality()),
                () -> assertEquals(sampleInt.intValue(), args.getInteger('d'))
        );
    }

    @Test
    void missingIntegerParameter() throws ArgsException, ParseException {
        final Args args = new Args("d#", new String[]{"-d"});
        assertEquals("Could not find integer parameter for: -d", args.getErrorMessage());
    }

    @Test
    void invalidIntegerParameter() throws ArgsException, ParseException {
        final Args args = new Args("d#", new String[]{"-d", "33s"});
        assertEquals("Invalid value:33s provided for integer argument:-d", args.getErrorMessage());
    }

    @Test
    void missingStringArg() throws Exception {
        Args args = new Args("x*", new String[]{"-x"});
        assertEquals("Could not find string parameter for: -x.", args.getErrorMessage());
        assertFalse(args.isValid());
    }

    @Test
    void spaceInFormat() throws ParseException, ArgsException {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertTrue(args.getBoolean('x')),
                () -> assertTrue(args.getBoolean('h'))
        );
    }

    @Test
    void usage() throws ParseException, ArgsException {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertEquals("-[x,h]", args.usage());
        args = new Args("", new String[]{});
        assertTrue(args.usage().isEmpty());
    }

    @Test
    void getBooleanForMissingArg() throws ParseException, ArgsException {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("", new String[]{"-xc"}));
        assertEquals("Unexpected argument:x found.", argsException.getErrorMessage());
    }

}