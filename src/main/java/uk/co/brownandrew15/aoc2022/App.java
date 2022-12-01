package uk.co.brownandrew15.aoc2022;

import uk.co.brownandrew15.aoc2022.exceptions.DayNotFoundException;
import uk.co.brownandrew15.aoc2022.exceptions.PartNotFoundException;

/**
 * The main dirver class of the Advent of Code 2022 solutions.
 */
public class App {
    public static void main(String[] args) {

        System.out.println(" === Advent of Code 2022 ===");
        System.out.println(" ======= Andrew Brown ======");

        if (args.length != 2){
            System.err.println("Not enough command line arguments");
            System.err.println("Please use ./AoC2022.sh <day> <part>");
            return;
        }

        String dayNumberString = args[0];
        int dayNumber = Integer.parseInt(dayNumberString);

        String partNum = args[1];

        try {
            Day day = DayFactory.getDay(dayNumber);
            System.out.println("The result of day " 
                                    + dayNumber + " part " + partNum + " is " 
                                    + getPartResult(day, partNum));

        } catch (DayNotFoundException | PartNotFoundException e) {
            System.out.println("The result of day " + dayNumber + " part " 
                                    + partNum + " could not be calculated!");
            e.printStackTrace();
        }
    }

    /**
     * Get the result of the given part for the given day.
     * 
     * @param day the day object for the day
     * @param part the part number
     * @return the String of the solution
     * @throws PartNotFoundException if the part number cannot be interpreted
     */
    private static String getPartResult(Day day, String part) throws PartNotFoundException {
        String result;
        if (part.equals("1")){
            result = day.solvePartOne();
        } else if (part.equals("2")) {
            result = day.solvePartTwo();
        } else {
            throw new PartNotFoundException(part);
        }
        return result;
    }
}
