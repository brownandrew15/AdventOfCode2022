package uk.co.brownandrew15.aoc2022;

import uk.co.brownandrew15.aoc2022.days.*; // import all the days

/**
 * Factory to return the class object corresponding to the given day number.
 */
public class DayFactory {
    
    /**
     * Returns the Day object for the given day.
     * 
     * @param dayNumber the day to get
     * @return the object corresponding to the day
     */
    public static Day getDay(int dayNumber) {

        return new Day00();

    }

}
