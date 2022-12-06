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

        if (dayNumber == 0) {
            return new Day00();
        } else if (dayNumber == 1) {
            return new Day01();
        } else if (dayNumber == 2) {
            return new Day02();
        } else if (dayNumber == 3) {
            return new Day03();
        } else if (dayNumber == 4) {
            return new Day04();
        } else if (dayNumber == 5) {
            return new Day05();
        } else if (dayNumber == 6) {
            return new Day06();
        } else {
            throw new DayNotFoundException(dayNumber);
        }


    }

}
