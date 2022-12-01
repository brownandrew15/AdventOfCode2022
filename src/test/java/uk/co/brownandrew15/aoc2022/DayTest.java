package uk.co.brownandrew15.aoc2022;

import org.junit.jupiter.api.BeforeEach;

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
        this.day = DayFactory.getDay(this.getDayNumber());
    }

    /**
     * Returns the day number that is being tested.
     * 
     * @return the day number
     */
    abstract public int getDayNumber();

}
