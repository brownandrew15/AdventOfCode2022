package uk.co.brownandrew15.aoc2022;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit test for InputReader class.
 */
public class InputReaderTest {

    /**
     * Tests that the input reader can correctly read the input files.
     */
    @Test
    public void testReadDay() {
        String[] filelines = InputReader.readDay(00);
        String[] expected = {"Advent","of","Code","2022"};
        assertArrayEquals(
            expected,
            filelines, 
            "The file lines array did not contain the lines from the file"
        );
    }
}
