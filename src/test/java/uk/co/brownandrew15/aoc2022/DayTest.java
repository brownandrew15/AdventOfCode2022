package uk.co.brownandrew15.aoc2022;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

import uk.co.brownandrew15.aoc2022.exceptions.DayNotFoundException;

/**
 * Abstract class to aggregate the common code of the day tests.
 */
public abstract class DayTest {

    protected Day day;
    
    /**
     * Before each test creates a new Day object for the given day.
     */
    @BeforeEach
    public void setup() {
        try {
            this.day = DayFactory.getDay(this.getDayNumber());
        } catch (DayNotFoundException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Returns the day number that is being tested.
     * 
     * @return the day number
     */
    abstract public int getDayNumber();

}
