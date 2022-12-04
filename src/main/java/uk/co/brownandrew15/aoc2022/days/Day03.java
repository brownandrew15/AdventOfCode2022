package uk.co.brownandrew15.aoc2022.days;

import java.util.ArrayList;
import java.util.List;

import uk.co.brownandrew15.aoc2022.Day;
import uk.co.brownandrew15.aoc2022.utils.types.Pair;

/**
 * Class for Day 3.
 */
public class Day03 extends Day {
    
    public int getDayNumber() {
        return 3;
    }

    public String solvePartOne() {
        List<Pair<String, String>> rucksacks = new ArrayList<Pair<String, String>>();
        for (int i=0; i < this.fileLines.length; i++) {
            Pair<String, String> compartments = this.getCompartmentContents(this.fileLines[i]);
            rucksacks.add(compartments);
        }

        int total = 0;
        for (int i=0; i < rucksacks.size(); i++) {
            char commonChar = this.findCommonCharacter(rucksacks.get(i).getLeft(), rucksacks.get(i).getRight());
            total += this.getCharPriority(commonChar);
        }
        return Integer.toString(total);
    }

    public String solvePartTwo() {
        return "";
    }


    /**
     * Splits the contents string into the two compartments.
     * 
     * @param contents the contents string
     * @return A pair containing the contents of the compartments
     */
    private Pair<String, String> getCompartmentContents(String contents) {
        int length = contents.length();
        return new Pair<String,String>(
            contents.substring(0, length/2), 
            contents.substring(length/2, length)
        );
    }


    /**
     * Find the common character between two strings.
     * 
     * @param first the first string
     * @param second the second string
     * @return the common character
     */
    private char findCommonCharacter(String first, String second) {
        for (int i=0; i<first.length(); i++) {
            for (int j=0; j<second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    return first.charAt(i);
                }
            }
        }
        return 'A'; // default - should not reach this point
    }

    /**
     * Returns the character priority.
     * 
     * @param character the character
     * @return the priority
     */
    private int getCharPriority(char character) {
        if ((character >= 'A') && (character <= 'Z')) {
            return (character - 'A') + 27;
        } else { // character >= 'a' || character <= 'z'
            return (character - 'a') + 1;
        }
    }

}
