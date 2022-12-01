package uk.co.brownandrew15.aoc2022.exceptions;

/**
 * Exception thrown to report that the part provided doesn't exist.
 * 
 * @author andrew
 */
public class PartNotFoundException extends Exception {
    
    /**
     * Constructs a PartNotFoundException with a default message.
     */
    public PartNotFoundException() {
        super("PartNotFoundException");
    }

    /**
     * Constructs a PartNotFoundException with an error message including the provided part number.
     * 
     * @param part the String of the part number
     */
    public PartNotFoundException(String part) {
        super("PartNotFoundException: Part " + part + " not found");
    }
}