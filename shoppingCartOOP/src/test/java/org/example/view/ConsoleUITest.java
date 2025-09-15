package org.example.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleUITest {
    ConsoleUI ui;

    //set up for each test
    @BeforeEach
    void setUp() {
        ui = new ConsoleUI();
    }
    @Test
    void displayMessage() {
        //act
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        ui.displayMessage("Hello Testing");
        //assert
        assertEquals("Hello Testing", out.toString().trim());
    }

    @Test
    void displayPrompt() {
        //act
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        ui.displayPrompt("Enter value");
        //assert
        assertEquals("Enter value: ", out.toString());
    }
}