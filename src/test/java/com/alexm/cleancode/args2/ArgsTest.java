package com.alexm.cleancode.args2;

import org.junit.jupiter.api.Test;

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
    void noSchemaNoArguments() {
        Args args = new Args("", new String[0]);
        assertThat(args.cardinality(), is(eq(0)));
    }

    @Test
    void noSchemaOneArgument() {
        Args args = new Args("", new String[]{"-x"});
        assertEquals("Argument (s) - x unexpected.", args.getErrorMessage());
    }

    @Test
    void noSchemaMultipleArguments() {
        Args args = new Args("", new String[]{"-x", "-y"});
        assertEquals("Argument (s) - x y unexpected.", args.getErrorMessage());
    }

    @Test
    void nonLetterSchema() {
        Args args = new Args("*", new String[]{});
        assertThat(0, is(eq(args.cardinality())));
        assertEquals("", args.getErrorMessage());
    }

    @Test
    void invalidArgumentFormat() {
        Args args = new Args("t%", new String[]{});
        //todo: implement me
    }

    @Test
    void simpleBooleanPresent() {
        Args args = new Args("x", new String[]{"-x"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertTrue(args.getBoolean('x'))
        );
    }

    @Test
    void spaceInFormat() {
        Args args = new Args("x,h", new String[]{"-xh"});
        assertAll("",
                () -> assertEquals(2, args.cardinality()),
                () -> assertTrue(args.getBoolean('x')),
                () -> assertTrue(args.getBoolean('h'))
        );
    }

}