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
    void noSchemaNoArguments() throws ParseException {
        Args args = new Args("", new String[0]);
        assertThat(args.cardinality(), is(eq(0)));
    }

    @Test
    void noSchemaOneArgument() throws Exception {
        Args args = new Args("", new String[]{"-x"});
        assertEquals("Argument (s) - x unexpected.", args.getErrorMessage());
    }

    @Test
    void noSchemaMultipleArguments() throws Exception {
        Args args = new Args("", new String[]{"-x", "-y"});
        assertEquals("Argument (s) - x y unexpected.", args.getErrorMessage());
    }

    @Test
    void spaceInSchema() throws ParseException {
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
    void invalidArgumentFormat() throws ParseException {
        Args args = new Args("t%", new String[]{});
        //todo: implement me
    }

    @Test
    void simpleBooleanPresent() throws ParseException {
        Args args = new Args("x", new String[]{"-x"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertTrue(args.getBoolean('x'))
        );
    }

    @Test
    void booleanAndStringPresent() throws ParseException {
        Args args = new Args("l,x*", new String[]{"-l", "-x", "test"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertEquals("test", args.getString('x')),
                () -> assertTrue(args.getBoolean('l'))
        );
    }

    @Test
    void simpleStringPresent() throws ParseException {
        Args args = new Args("x*", new String[]{"-x",  "test"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertEquals("test", args.getString('x'))
        );
    }

    @Test
    void missingStringArg() throws Exception {
        Args args = new Args("x*", new String[]{"-x"});
        assertEquals("Could not find string parameter for -x.", args.getErrorMessage());
        assertFalse(args.isValid());
    }

    @Test
    void spaceInFormat() throws ParseException {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertTrue(args.getBoolean('x')),
                () -> assertTrue(args.getBoolean('h'))
        );
    }

    @Test
    void usage() throws ParseException {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertEquals("-[x,h]", args.usage());
        args = new Args("", new String[]{});
        assertTrue(args.usage().isEmpty());
    }

}