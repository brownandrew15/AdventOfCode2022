package uk.co.brownandrew15.aoc2022;

/**
 * The abstract class that all the Day classes need to extend.
 * This ensures that each day has a part 1 and part 2 and has 
 * a constructor that reads the input into array of lines.
 */
public abstract class Day {

    /**
     * Variable that stores an array of the input file lines.
     */
    protected String[] fileLines; 


    /**
     * Constructs a Day class object.
     */
    public Day() {
        int dayNumber = this.getDayNumber();
        this.fileLines = InputReader.readDay(dayNumber);
    }


    /**
     * Returns the day number.
     * 
     * @return the day number
     */
    abstract public int getDayNumber();
    
    /**
     * Returns the solution for part 1.
     * 
     * @return the solution
     */
    abstract public String solvePartOne();

    /**
     * Returns the solution for part 2.
     * 
     * @return the solution
     */
    abstract public String solvePartTwo();
    
}
