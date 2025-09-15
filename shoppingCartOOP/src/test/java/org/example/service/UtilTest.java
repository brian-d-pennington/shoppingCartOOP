package org.example.service;

import org.example.utils.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UtilTest {
    private Util util;

    @BeforeEach
    void setUp() {
        util = new Util();
        // silence console output during tests
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    private void setConsoleInput(String data) throws Exception {
        System.setIn(new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8)));
        var field = Util.class.getDeclaredField("console");
        field.setAccessible(true);
        field.set(null, new java.util.Scanner(System.in));
    }

    @Test
    void roundMoneyTwoDecimals() {
        assertEquals(3.46, util.roundMoneyTwoDecimals(3.456));
    }

    @Test
    void promptUserForInt() throws Exception {
        setConsoleInput("42");
        assertEquals(42, util.promptUserForInt("Enter an int:"));
    }

    @Test
    void promptUserForIntInRange() throws Exception {
        setConsoleInput("7");
        assertEquals(7, util.promptUserForIntInRange("Pick 1-10:", 1, 10));
    }

    @Test
    void promptUserForString() throws Exception {
        setConsoleInput("hello world");
        assertEquals("hello world", Util.promptUserForString("Say something:"));
    }
    @Test
    void promptUserForYN_parsesYesAfterRetry() throws Exception {
        setConsoleInput("Y");
        assertTrue(util.promptUserForYN("Proceed?"));
    }
}
