package uk.co.brownandrew15.aoc2022;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import uk.co.brownandrew15.aoc2022.days.*; // import all the days
import uk.co.brownandrew15.aoc2022.exceptions.DayNotFoundException;

/**
 * Tests the DayFactory class.
 */
public class DayFactoryTest {

    /**
     * Tests that the DayNotFoundException is thrown when an invalid day is passed.
     */
    @Test
    public void testInvalidDay() {
        assertThrows(DayNotFoundException.class, () -> {
            DayFactory.getDay(-1);
        });
    }
    
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

    /**
     * Tests that a Day02 object is returned for day 2.
     */
    @Test
    public void testGetDay02() {
        try {
            Day day = DayFactory.getDay(2);
            assertEquals(day.getClass(), Day02.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Tests that a Day03 object is returned for day 3.
     */
    @Test
    public void testGetDay03() {
        try {
            Day day = DayFactory.getDay(3);
            assertEquals(day.getClass(), Day03.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Tests that a Day04 object is returned for day 4.
     */
    @Test
    public void testGetDay04() {
        try {
            Day day = DayFactory.getDay(4);
            assertEquals(day.getClass(), Day04.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Tests that a Day05 object is returned for day 5.
     */
    @Test
    public void testGetDay05() {
        try {
            Day day = DayFactory.getDay(5);
            assertEquals(day.getClass(), Day05.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Tests that a Day06 object is returned for day 6.
     */
    @Test
    public void testGetDay06() {
        try {
            Day day = DayFactory.getDay(6);
            assertEquals(day.getClass(), Day06.class);
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

}
