package uk.co.brownandrew15.aoc2022.days;

import java.util.ArrayList;
import java.util.List;

import uk.co.brownandrew15.aoc2022.Day;
import uk.co.brownandrew15.aoc2022.utils.Array;

/**
 * Class for Day 1.
 */
public class Day01 extends Day {

    private List<Integer> calories;

    public Day01() {
        super();
        this.calories = new ArrayList<Integer>();
        processFileLines();
    }
    
    public int getDayNumber() {
        return 1;
    }

    public String solvePartOne() {
        int maxCalories = this.getSumOfMaximums(1);
        return Integer.toString(maxCalories);
    }

    public String solvePartTwo() {
        int caloriesSum = this.getSumOfMaximums(3);
        return Integer.toString(caloriesSum);
    }


    /**
     * Processes the file lines.
     */
    private void processFileLines() {
        int elfTotal = 0;
        for (int i = 0; i < this.fileLines.length; i++){
            String line = this.fileLines[i];
            if (line.isEmpty()) {
                // the line is blank - end of current elf
                this.calories.add(elfTotal);
                elfTotal = 0;
            } else {
                elfTotal += Integer.parseInt(line);
            }
        }

        // add the last elf - there is no blank line after the last one
        this.calories.add(elfTotal);
    }


    /**
     * Returns the sum of the top n numbers in a list.
     * 
     * @param count the value of n
     * @return the sum of the top n values
     */
    private int getSumOfMaximums(int count) {
        int[] maxValues = new int[count];

        // fill the array with the first n items of the calories list
        for (int i=0; i < count; i++) {
            maxValues[i] = this.calories.get(i);
        }

        // for each subsequent item in the calories list
        for (int i=count; i < this.calories.size(); i++){
            int currentLowestIndex = Array.getIndexOfLowestValue(maxValues);
            int currentLowestValue = maxValues[currentLowestIndex];
            int currentCalories = this.calories.get(i);
            if (currentLowestValue < currentCalories) {
                maxValues[currentLowestIndex] = currentCalories;
            }
        }

        return Array.sumArray(maxValues);
    }

}
