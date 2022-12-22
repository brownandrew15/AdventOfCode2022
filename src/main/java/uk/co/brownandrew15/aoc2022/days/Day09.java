package uk.co.brownandrew15.aoc2022.days;

import java.util.ArrayList;
import java.util.List;

import uk.co.brownandrew15.aoc2022.Day;
import uk.co.brownandrew15.aoc2022.utils.types.Pair;
import uk.co.brownandrew15.aoc2022.utils.types.Set;

/**
 * Class for Day 9.
 */
public class Day09 extends Day {

    private List<Pair<Character, Integer>> commands;
    private List<Pair<Integer, Integer>> knotLocations;
    
    public int getDayNumber() {
        return 9;
    }

    public String solvePartOne() {
        this.commands = this.processCommands(this.fileLines);
        this.knotLocations = this.createRope(2);
        Set<Pair<Integer, Integer>> tailLocations = this.executeCommands();
        int numLocationsVisited = tailLocations.size();
        return Integer.toString(numLocationsVisited);
    }

    public String solvePartTwo() {
        return "";
    }


    /**
     * Process the commands from the input file.
     * 
     * @param commandsList the lines of the input file
     * @return the processed commands
     */
    private List<Pair<Character, Integer>> processCommands(String[] commandsList) {
        List<Pair<Character, Integer>> commands = new ArrayList<Pair<Character, Integer>>();
        for (String command : commandsList) {
            String[] commandArray = command.split(" ");
            char direction = commandArray[0].charAt(0);
            int distance = Integer.parseInt(commandArray[1]);
            commands.add(new Pair<Character, Integer>(direction, distance));
        }
        return commands;
    }


    /**
     * Creates a list of where all the knots are on the rope relative to the starting position.
     * 
     * @param numberOfKnots the number of knots on the rope
     * @return the list of knot positions
     */
    private List<Pair<Integer, Integer>> createRope(int numberOfKnots) {
        List<Pair<Integer, Integer>> knots = new ArrayList<Pair<Integer, Integer>>();
        for (int i=0; i < numberOfKnots; i++) {
            knots.add(new Pair<Integer, Integer>(0, 0));
        }
        return knots;
    }


    /**
     * Exceute the commands.
     * 
     * @return the set of locations that the tail visits
     */
    private Set<Pair<Integer, Integer>> executeCommands() {
        Set<Pair<Integer, Integer>> tailLocations = new Set<Pair<Integer, Integer>>();
        for (Pair<Character, Integer> command : this.commands) {
            List<Pair<Integer, Integer>> tailTrace = this.moveRope(command.getLeft(), command.getRight());
            for (Pair<Integer, Integer> location : tailTrace) {
                tailLocations.add(location);
            }
        }
        return tailLocations;
    }


    /**
     * Moves the rope in the direction and for the given distance.
     * 
     * @param direction the direction character
     * @param distance the distance to move the rope
     * @return the locations that the tail visits
     */
    private List<Pair<Integer, Integer>> moveRope(char direction, int distance) {
        List<Pair<Integer, Integer>> tailTrace = new ArrayList<Pair<Integer, Integer>>();
        for (int i=0; i < distance; i++) {
            Pair<Integer, Integer> newFrontKnotLocation = this.getNewFrontKnotLocation(this.getFrontKnot(), direction);
            if (this.shouldRemainingRopeMove(newFrontKnotLocation, this.knotLocations.get(1))) {
                this.shiftRope(newFrontKnotLocation);
            } else {
                this.knotLocations.set(0, newFrontKnotLocation);
            }
            tailTrace.add(this.getTail());
        }
        return tailTrace;
    }

    /**
     * Returns the new position of the front knot after moving in the given direction.
     * 
     * @param current the current front knot position
     * @param direction the direction to move the knot in
     * @return the new front knot location
     */
    private Pair<Integer, Integer> getNewFrontKnotLocation(Pair<Integer, Integer> current, char direction) {
        if (direction == 'U') {
            return new Pair<Integer, Integer>(current.getLeft(), current.getRight() + 1);
        } else if (direction == 'D') {
            return new Pair<Integer, Integer>(current.getLeft(), current.getRight() - 1);
        }  else if (direction == 'L') {
            return new Pair<Integer, Integer>(current.getLeft() - 1, current.getRight());
        } else { // direction == 'R'
            return new Pair<Integer, Integer>(current.getLeft() + 1, current.getRight());
        }
    }


    /**
     * Returns if the rest of the knots need to follow the front knot.
     * This happens when the front knot is ever two steps directly up, 
     * down, left, or right from the next knot back.
     * 
     * @param newFrontKnotLocation the new location of the front knot
     * @param nextKnotLocation the location of the next knot on the rope
     * @return true if the rest of the rope needs to follow the first knot
     */
    private boolean shouldRemainingRopeMove(Pair<Integer, Integer> newFrontKnotLocation, Pair<Integer, Integer> nextKnotLocation) {
        int xDistance = Math.abs(newFrontKnotLocation.getLeft() - nextKnotLocation.getLeft());
        int yDistance = Math.abs(newFrontKnotLocation.getRight() - nextKnotLocation.getRight());
        return ((xDistance > 1) || (yDistance > 1));
    }


    /**
     * Shifts the rope and sets the new front knot location.
     * 
     * @param newFrontKnotLocation the new front knot location
     */
    private void shiftRope(Pair<Integer, Integer> newFrontKnotLocation) {
        for (int i=1; i < this.knotLocations.size(); i++) {
            this.knotLocations.set(i, this.knotLocations.get(i-1));
        }
        this.knotLocations.set(0, newFrontKnotLocation);
    }


    /**
     * Returns the location of the front knot.
     * 
     * @return the location of the front knot
     */
    private Pair<Integer, Integer> getFrontKnot() {
        return this.knotLocations.get(0);
    }

    /**
     * Returns the location of the tail.
     * 
     * @return the location of the tail
     */
    private Pair<Integer, Integer> getTail() {
        return this.knotLocations.get(this.knotLocations.size() - 1);
    }


}