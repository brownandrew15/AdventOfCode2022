package uk.co.brownandrew15.aoc2022.utils;

/**
 * Class to contain methods related to array handling.
 */
public class Array {
    
    /**
     * Converts an array of integers to a string for output.
     * 
     * @param array the array of integers
     * @return the string representation
     */
    public static String intsToString(int[] array) {
        String str = "[";
        for (int i=0; i < array.length; i++) {
            if (!(i == 0)) {
                str += ", ";
            }
            str += Integer.toString(array[i]);
        }
        str += "]";
        return str;
    }


    /**
     * Returns the index of the lowest value in the array.
     * 
     * @param array the array
     * @return the index of the lowest value
     */
    public static int getIndexOfLowestValue(int[] array) {
        int lowestIndex = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] < array[lowestIndex]) {
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    /**
     * Returns the sum of an array of integers.
     * 
     * @param array the array of integers
     * @return the sum of the integers
     */
    public static int sumArray(int[] array) {
        int total = 0;
        for (int i=0; i < array.length; i++){
            total += array[i];
        }
        return total;
    }


}
