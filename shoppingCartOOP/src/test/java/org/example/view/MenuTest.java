package org.example.view;

import org.example.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MenuTest {
    Menu testMenu;
    List<Item> itemListToTest;

    @BeforeEach
    void setUp() {
        testMenu = new Menu();
    }

    @Test
    void testDisplayMenuNotNull() {
        // arrange

        // act
        List<Item> menuTest = testMenu.createMenu();
        // assert
        assertNotNull(menuTest);
    }

    @Test
    void testCreateMenuReturnsCorrectLength() {
        // arrange
        int expected = 8;
        // act
        List<Item> menuTest = testMenu.createMenu();
        // assert
        assertEquals(expected, menuTest.size());
    }

    @Test
    void testFirstIndexValueOfReturnedList() {
        // arrange
        Item testItem = new Item("Hershey Bar", 2.00);
        String expected = testItem.getName();
        // act
        List<Item> menuTest = testMenu.createMenu();
        // assert
        assertEquals(expected, menuTest.get(0).getName());
    }
}
