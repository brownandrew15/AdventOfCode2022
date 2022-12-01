package uk.co.brownandrew15.aoc2022.days;

import uk.co.brownandrew15.aoc2022.Day;

/**
 * Class for Day 1.
 */
public class Day01 extends Day {
    
    public int getDayNumber() {
        return 1;
    }

    public String solvePartOne() {
        int maxCalories = 0;
        int elfTotal = 0;

        for (int i = 0; i < this.fileLines.length; i++){
            String line = this.fileLines[i];
            if (line.isEmpty()) {
                // the line is blank - end of current elf
                maxCalories = Math.max(maxCalories, elfTotal);
                elfTotal = 0;
            } else {
                elfTotal += Integer.parseInt(line);
            }
        }
        // check for the last elf
        maxCalories = Math.max(maxCalories, elfTotal);

        // return the max calories
        return Integer.toString(maxCalories);
    }

    public String solvePartTwo() {
        return "";
    }



}
