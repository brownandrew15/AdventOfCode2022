package uk.co.brownandrew15.aoc2022.days;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uk.co.brownandrew15.aoc2022.DayTest;

public class Day04Test extends DayTest {

    /**
     * The day number.
     */
    private final int DAY_NUMBER = 4;

    /**
     * Returns the day number.
     * 
     * @return the day number
     */
    public int getDayNumber() {
        return this.DAY_NUMBER;
    }

    /**
     * Tests that the correct day number is returned from the class object.
     */
    @Test
    public void testGetDayNumber() {
        assertEquals(this.DAY_NUMBER, this.day.getDayNumber());
    }

    @Test
    public void testSolvePartOne() {
        String actual = this.day.solvePartOne();
        assertEquals("2", actual, "The number of pairs of elves that overlap fully was not the expected number");
    }

    @Test
    public void testSolvePartTwo() {
        String actual = this.day.solvePartTwo();
        assertEquals("", actual, "");
    }

}
