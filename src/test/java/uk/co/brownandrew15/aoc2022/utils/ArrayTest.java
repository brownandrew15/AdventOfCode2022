package uk.co.brownandrew15.aoc2022.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class to test the Array class.
 */
public class ArrayTest {

    /**
     * Tests that an array of integers is represented correctly as a string.
     */
    @Test
    public void testIntsToString() {
        int[] array = {1,2,3};
        assertEquals("[1, 2, 3]", Array.intsToString(array), "The string of the array was not the expected string");
    }


    /**
     * Tests that the index of the lowest value can be returned correctly.
     */
    @Test
    public void testGetIndexOfLowestValue() {
        int[] array = {1, 2, 3};
        assertEquals(0, Array.getIndexOfLowestValue(array), "The index of the lowest value was not the expected value");
    }

    /**
     * Tests that an array of integers can be summed correctly.
     */
    @Test
    public void testSumArray() {
        int[] array = {1, 2, 3};
        assertEquals(6, Array.sumArray(array), "The sum of the array was not the expected value");
    }
    
}
