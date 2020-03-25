package com.alexm.cleancode.args2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;

/**
 * @author AlexM
 * Date: 3/14/20
 **/
class ArgsTest {

    @Test
    void noSchemaNoArguments() throws ArgsException {
        Args args = new Args("", new String[0]);
        assertThat(args.cardinality(), is(eq(0)));
    }

    @Test
    void noSchemaOneArgument() {
        final ArgsException argsException = assertThrows(ArgsException.class, () ->  new Args("", new String[]{"-x"}));
        assertEquals("Unexpected argument:x found.", argsException.getErrorMessage());
    }

    @Test
    void noSchemaMultipleArguments() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("", new String[]{"-x", "-y"}));
        assertEquals("Unexpected argument:x found.", argsException.getErrorMessage());
    }

    @Test
    void spaceInSchema() throws ArgsException {
        final Args args = new Args("k,     p,          d", new String[]{"-kpd"});
        assertAll("space",
                () -> assertEquals(3, args.cardinality()));
    }

    @Test
    void nonLetterSchema() {
        final ArgsException ex = assertThrows(ArgsException.class,
                () -> new Args("*333", new String[]{}));
        assertThat(ex.getErrorMessage(), is("Bad character:* in schema format."));
    }

    @Test
    void invalidArgumentFormat() throws ArgsException {
        Args args = new Args("t%", new String[]{});
        //todo: implement me
    }

    @Test
    void simpleBooleanPresent() throws ArgsException {
        Args args = new Args("x", new String[]{"-x"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertTrue(args.getBoolean('x'))
        );
    }

    @Test
    void booleanAndStringPresent() throws ArgsException {
        Args args = new Args("l,x*", new String[]{"-l", "-x", "test"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertEquals("test", args.getString('x')),
                () -> assertTrue(args.getBoolean('l'))
        );
    }

    @Test
    void simpleStringPresent() throws ArgsException {
        Args args = new Args("x*", new String[]{"-x",  "test"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertEquals("test", args.getString('x'))
        );
    }

    @Test
    void simpleIntegerPresent() throws ArgsException {
        Integer sampleInt = 33;
        final Args args = new Args("d#", new String[]{"-d", sampleInt.toString()});
        assertAll("get integer",
                () -> assertEquals(1, args.cardinality()),
                () -> assertEquals(sampleInt.intValue(), args.getInteger('d'))
        );
    }

    @Test
    void missingIntegerParameter() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("d#", new String[]{"-d"}));
        assertEquals("Could not find integer parameter for: -d", argsException.getErrorMessage());
    }

    @Test
    void invalidIntegerParameter() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("d#", new String[]{"-d", "33s"}));
        assertEquals("Invalid value:33s provided for integer argument:-d", argsException.getErrorMessage());
    }

    @Test
    void missingStringArg() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("x*", new String[]{"-x"}));
        assertEquals("Could not find string parameter for: -x.", argsException.getErrorMessage());
    }

    @Test
    void spaceInFormat() throws ArgsException {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertTrue(args.getBoolean('x')),
                () -> assertTrue(args.getBoolean('h'))
        );
    }

    @Test
    void usage() throws ArgsException {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertEquals("-[x,h]", args.usage());
        args = new Args("", new String[]{});
        assertTrue(args.usage().isEmpty());
    }

    @Test
    void getBooleanForMissingArg() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("", new String[]{"-xc"}));
        assertEquals("Unexpected argument:x found.", argsException.getErrorMessage());
    }

    @Test
    void simpleDoublePresent() throws ArgsException {
        final Args args = new Args("d##", new String[]{"-d", "2.33"});
        assertTrue(args.isValid());
        assertEquals(1, args.cardinality());
        assertTrue(args.has('d'));
        assertEquals(2.33, args.getDouble('d'));
    }

    @Test
    void invalidDouble() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("d##", new String[]{"-d", "d"}));
        assertThat(argsException.getErrorMessage(), is("Invalid value:d provided for double argument:-d"));
    }

    @Test
    void missingDouble() {
        final ArgsException argsException = assertThrows(ArgsException.class, () -> new Args("d##", new String[]{"-d"}));
        assertThat(argsException.getErrorMessage(), is("Could not find double parameter for argument -d."));
    }

}