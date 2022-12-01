package uk.co.brownandrew15.aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uk.co.brownandrew15.aoc2022.days.*; // import all the days

/**
 * Tests the DayFactory class.
 */
public class DayFactoryTest {
    
    /**
     * Tests that a Day00 object is returned for day 0.
     */
    @Test
    public void testGetDay00() {
        Day day = DayFactory.getDay(0);
        assertEquals(day.getClass(), Day00.class);
    }

}
