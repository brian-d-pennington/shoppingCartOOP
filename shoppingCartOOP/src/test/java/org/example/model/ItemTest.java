package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
    //Arrange
    Item itemTest = new Item("testName", 4.00);

    @Test
    public void getPriceTest() {
        Double expected = 4.00;
        //ACT
        Double actual = itemTest.getPrice();
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    public void setPriceTest() {
        Double expected = 6.00;
        //ACT
        itemTest.setPrice(6.00);
        //ASSERT
        assertEquals(expected, itemTest.getPrice());

    }

    @Test
    public void getNameTest() {
        String expected = "testName";
        //ACT
        String actual = itemTest.getName();
        //ASSERT
        assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() {
        String expected = "goodTestName";
        //ACT
        itemTest.setName("goodTestName");
        //ASSERT
        assertEquals(expected, itemTest.getName());
    }
}
