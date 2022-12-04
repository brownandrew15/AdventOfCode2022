package uk.co.brownandrew15.aoc2022.days;

import java.util.ArrayList;
import java.util.Arrays;
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
            String[] rucksack = {rucksacks.get(i).getLeft(), rucksacks.get(i).getRight()};
            char commonChar = this.findCommonCharacter(rucksack);
            total += this.getCharPriority(commonChar);
        }
        return Integer.toString(total);
    }

    public String solvePartTwo() {
        int total = 0;
        for (int i=0; i < this.fileLines.length; i+=3) {
            String[] elfGroup = {this.fileLines[i], this.fileLines[i+1], this.fileLines[i+2]};
            char commonChar = this.findCommonCharacter(elfGroup);
            total += this.getCharPriority(commonChar);
        }
        return Integer.toString(total);
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
     * Returns the common character for an array of Strings.
     * 
     * @param strings the list of strings to find the common character for
     * @return the common character
     */
    private char findCommonCharacter(String strings[]) {
        // get each string sorted by character
        for (int i=0; i < strings.length; i++) {
            String str = strings[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strings[i] = new String(chars);
        }

        String first = strings[0];
        for (int i=0; i < first.length(); i++) {
            // the common character must be in the first string so only need to loop through the first
            if (this.allStringsContain(first.charAt(i), strings)) {
                return first.charAt(i);
            }
        }

        return 'A'; // default case - should not get to this point
    }

    /**
     * Returns if the character can be found in all the strings in the array.
     * 
     * @param character the character to check for
     * @param strings the strings to check
     * @return true if the character can be found in all the strings, false otherwise
     */
    private boolean allStringsContain(char character, String[] strings) {
        // prepare the character for the contains check - needs to be as a string
        char[] chars = {character};
        String charString = new String(chars);
        // for each of the strings
        for (int i=0; i < strings.length; i++) {
            if (!(strings[i].contains(charString))) {
                return false;
            }
        }
        // all strings passed the test
        return true;
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
