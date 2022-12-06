package uk.co.brownandrew15.aoc2022.days;

import java.util.HashMap;
import java.util.Map;

import uk.co.brownandrew15.aoc2022.Day;

/**
 * Class for Day 6.
 */
public class Day06 extends Day {
    
    public int getDayNumber() {
        return 6;
    }

    public String solvePartOne() {
        int substringLength = 4;
        int startIndex = this.getIndexOfUniqueCharSubstring(this.fileLines[0], substringLength);
        return Integer.toString(startIndex + substringLength);
    }

    public String solvePartTwo() {
        int substringLength = 14;
        int startIndex = this.getIndexOfUniqueCharSubstring(this.fileLines[0], substringLength);
        return Integer.toString(startIndex + substringLength);
    }


    /**
     * Returns the start index for the first substring of length n where there are no repeated characters.
     * 
     * @param string the string to find the substring from
     * @param substringLength the substring length n
     * @return the start index of the first substring that has no repeated characters, returns -1 if there is no such substring
     */
    private int getIndexOfUniqueCharSubstring(String string, int substringLength) {
        for (int i=0; i < (string.length() - substringLength); i++) {
            String subString = string.substring(i, i + substringLength);
            if (!(this.isACharacterRepeated(subString))) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Returns if a string contains the same character more than once.
     * 
     * @param sequence the string to check
     * @return true if a character is repeated in the string, false otherwise
     */
    private boolean isACharacterRepeated(String sequence) {
        Map<Character, Integer> instances = new HashMap<Character, Integer>();
        for (int i=0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);
            if (instances.keySet().contains(c)) {
                instances.put(c, instances.get(c) + 1);
            } else {
                instances.put(c, 1);
            }
        }
        for (char c : instances.keySet()) {
            if (instances.get(c) > 1) {
                return true;
            }
        }
        return false;
    }

}
