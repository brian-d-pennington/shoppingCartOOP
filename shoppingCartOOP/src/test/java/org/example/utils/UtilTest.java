package org.example.utils;

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

    //set up for each test
    @BeforeEach
    void setUp() {
        util = new Util();
    }

    //helper method to arrange all tests
    private void setConsoleInput(String data) throws Exception {
        System.setIn(new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8)));
        var field = Util.class.getDeclaredField("console");
        field.setAccessible(true);
        field.set(null, new java.util.Scanner(System.in));
    }

    @Test
    void roundMoneyTwoDecimals() {
        //act + assert
        assertEquals(3.46, util.roundMoneyTwoDecimals(3.456));
    }

    @Test
    void promptUserForInt() throws Exception {
        //act
        setConsoleInput("42");
        //assert
        assertEquals(42, util.promptUserForInt("Enter an int:"));
    }

    @Test
    void promptUserForIntInRange() throws Exception {
        //act
        setConsoleInput("7");
        //assert
        assertEquals(7, util.promptUserForIntInRange("Pick 1-10:", 1, 10));
    }

    @Test
    void promptUserForString() throws Exception {
        //act
        setConsoleInput("hello world");
        //assert
        assertEquals("hello world", Util.promptUserForString("Say something:"));
    }
    @Test
    void promptUserForYN_parsesYesAfterRetry() throws Exception {
        //act
        setConsoleInput("Y");
        //assert
        assertTrue(util.promptUserForYN("Proceed?"));
    }
}
