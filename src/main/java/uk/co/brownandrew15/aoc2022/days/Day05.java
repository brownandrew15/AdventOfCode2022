package uk.co.brownandrew15.aoc2022.days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.brownandrew15.aoc2022.Day;
import uk.co.brownandrew15.aoc2022.utils.types.Pair;
import uk.co.brownandrew15.aoc2022.utils.types.Stack;

/**
 * Class for Day 5.
 */
public class Day05 extends Day {
    
    public int getDayNumber() {
        return 5;
    }

    public String solvePartOne() {
        Pair<Map<Integer, Stack<Character>>, List<String>> inputs = this.processInput();
        Map<Integer, Stack<Character>> containers = inputs.getLeft();
        List<String> instructions = inputs.getRight();
        this.processInstructions(instructions, containers);
        return this.getMessage(containers);
    }

    public String solvePartTwo() {
        return "";
    }


    /**
     * Processes the input from the input file.
     * 
     * @return A pair containing the list of instructions and the container stacks
     */
    private Pair<Map<Integer, Stack<Character>>, List<String>> processInput() {
        List<String> containersList = new ArrayList<String>();
        List<String> instructions = new ArrayList<String>();
        boolean foundBlank = false;
        for (int i=0; i < this.fileLines.length; i++) {
            String line = this.fileLines[i];
            if (line.isEmpty()) {
                foundBlank = true;
            } else {
                if (foundBlank) {
                    instructions.add(line);
                } else {
                    containersList.add(line);
                }
            }
        }
        Map<Integer, Stack<Character>> containers = this.processContainers(containersList);
        return new Pair<Map<Integer, Stack<Character>>, List<String>>(containers, instructions);
    }

    /**
     * Processes the container contents into stacks.
     * 
     * @param containersList the list of container lines from the input file
     * @return the map from stack number to container stack
     */
    private Map<Integer, Stack<Character>> processContainers(List<String> containersList) {
        Map<Integer, Stack<Character>> containers = new HashMap<Integer, Stack<Character>>();

        // reverse the list so the elements can be added to their respective stacks in list order
        Collections.reverse(containersList);

        for (int i=0; i < containersList.size(); i++) {
            List<Character> values = this.getContainerLineValues(containersList.get(i));
            for (int j=1; j <= values.size(); j++) {
                if (i == 0) {
                    // the first list element wil be the stack numbers
                    containers.put(j, new Stack<Character>()); // the containers are numbered from 1
                } else {
                    // the other elements will be the container letters
                    char c = values.get(j - 1);
                    if (!(c == ' ')) {
                        containers.get(j).push(c);
                    }
                }
            }
        }
        return containers;
    }

    /**
     * Returns the list of values that the containers have from a given line of the input file.
     * 
     * @param line the input file line
     * @return the list of container values
     */
    private List<Character> getContainerLineValues(String line) {
        // need to read characters 4n + 1 where n >= 0
        List<Character> characters = new ArrayList<Character>();
        for (int i=0; i < line.length(); i+=4) {
            characters.add(line.charAt(i + 1));
        }
        return characters;
    }

    /**
     * Processes the instruction from the input file.
     * 
     * @param instructions the list of instructions from the input file
     * @param containers the map of the containers
     */
    private void processInstructions(List<String> instructions, Map<Integer, Stack<Character>> containers) {
        for (int i=0; i < instructions.size(); i++) {
            String instruction = instructions.get(i);
            String[] instructionArray = instruction.split(" ");
            int[] instructionValues = {
                Integer.parseInt(instructionArray[1]),  // number to move
                Integer.parseInt(instructionArray[3]),  // from stack
                Integer.parseInt(instructionArray[5])   // to stack
            };
            for (int j=0; j < instructionValues[0]; j++) {
                this.moveContainer(containers, instructionValues[1], instructionValues[2]);
            }
        }
    }

    /**
     * Moves a container from one stack to another.
     * 
     * @param containers the map of containers
     * @param from the stack number to move the container from
     * @param to the stack number to move the container to
     */
    private void moveContainer(Map<Integer, Stack<Character>> containers, int from, int to) {
        char character = containers.get(from).pop();
        containers.get(to).push(character);
    }

    /**
     * Returns the message that is created from the characters on the containers at the top of each stack.
     * 
     * @param containers the map of the container stacks
     * @return the message from the containers
     */
    private String getMessage(Map<Integer, Stack<Character>> containers) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i=1; i <= containers.size(); i++) {
            strBuilder.append(containers.get(i).peek());
        }
        return strBuilder.toString();
    }

}
