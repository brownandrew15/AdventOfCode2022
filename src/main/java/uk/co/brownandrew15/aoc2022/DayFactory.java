package uk.co.brownandrew15.aoc2022;

import uk.co.brownandrew15.aoc2022.days.*; // import all the days
import uk.co.brownandrew15.aoc2022.exceptions.DayNotFoundException;

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
    public static Day getDay(int dayNumber) throws DayNotFoundException {

        // check the day is in range
        if ((dayNumber < 0) || (dayNumber > 25)) {
            throw new DayNotFoundException(Integer.toString(dayNumber));
        }

        if (dayNumber == 0) {
            return new Day00();
        } else if (dayNumber == 1) {
            return new Day01();
        }

        return new Day00();

    }

}
