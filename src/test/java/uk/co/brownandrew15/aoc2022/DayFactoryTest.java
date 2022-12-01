package uk.co.brownandrew15.aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import uk.co.brownandrew15.aoc2022.days.*; // import all the days
import uk.co.brownandrew15.aoc2022.exceptions.DayNotFoundException;

/**
 * Tests the DayFactory class.
 */
public class DayFactoryTest {
    
    /**
     * Tests that a Day00 object is returned for day 0.
     */
    @Test
    public void testGetDay00() {
        try {
            Day day = DayFactory.getDay(0);
            assertEquals(day.getClass(), Day00.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Tests that a Day01 object is returned for day 1.
     */
    @Test
    public void testGetDay01() {
        try {
            Day day = DayFactory.getDay(1);
            assertEquals(day.getClass(), Day01.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

}
