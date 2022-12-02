package uk.co.brownandrew15.aoc2022.exceptions;

/**
 * Exception thrown to report that the day provided to the DayFactory doesn't exist.
 * 
 * @author andrew
 */
public class DayNotFoundException extends Exception {
    
    /**
     * Constructs a DayNotFoundException with a default message.
     */
    public DayNotFoundException() {
        super("DayNotFoundException");
    }

    /**
     * Constructs a DayNotFoundException with an error message including the provided day number.
     * 
     * @param day the day number
     */
    public DayNotFoundException(int day) {
        super("DayNotFoundException: Day " + Integer.toString(day) + " not found");
    }
}