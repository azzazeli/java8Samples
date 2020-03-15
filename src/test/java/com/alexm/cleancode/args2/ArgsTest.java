package com.alexm.cleancode.args2;

import org.junit.jupiter.api.Test;

import static com.alexm.cleancode.args2.ArgsException.ErrorCode.*;
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
    void noSchemaNoArguments() throws ArgsException {
        Args args = new Args("", new String[0]);
        assertThat(args.cardinality(), is(eq(0)));
    }

    @Test
    void noSchemaOneArgument() {
        final ArgsException exception = assertThrows(ArgsException.class, () -> new Args("", new String[]{"-x"}));
        assertThat(exception.errorCode(), is(eq(UNEXPECTED_ARGUMENT)));
        assertThat(exception.errorArgumentId(), is(eq('x')));
    }

    @Test
    void noSchemaMultipleArguments() {
        final ArgsException exception = assertThrows(ArgsException.class, () -> new Args("", new String[]{"-x", "-y"}));
        assertThat(exception.errorCode(), is(eq(UNEXPECTED_ARGUMENT)));
        assertThat(exception.errorArgumentId(), is(eq('x')));
    }

    @Test
    void nonLetterSchema() {
        final ArgsException ex = assertThrows(ArgsException.class, () -> new Args("*", new String[]{}));
        assertThat(ex.errorCode(), is(eq(INVALID_ARGUMENT_NAME)));
    }

    @Test
    void invalidArgumentFormat() {
        final ArgsException ex = assertThrows(ArgsException.class, () -> new Args("t%", new String[]{}));
        assertThat(ex.errorCode(), is(eq(INVALID_ARGUMENT_FORMAT)));
        assertThat(ex.errorArgumentId(), is(eq('f')));
    }

    @Test
    void simpleBooleanPresent() throws ArgsException {
        Args args = new Args("x", new String[]{"x"});
        assertAll("",
                () -> assertEquals(1, args.cardinality()),
                () -> assertTrue(args.getBoolean('x'))
        );
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

}