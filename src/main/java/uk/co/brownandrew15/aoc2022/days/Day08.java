package uk.co.brownandrew15.aoc2022.days;

import uk.co.brownandrew15.aoc2022.Day;

/**
 * Class for Day 8.
 */
public class Day08 extends Day {
    
    public int getDayNumber() {
        return 8;
    }

    public String solvePartOne() {
        int[][] grid = createGrid(this.fileLines);
        int visibleTrees = this.countVisibleTrees(grid);
        return Integer.toString(visibleTrees);
    }

    public String solvePartTwo() {
        int[][] grid = createGrid(this.fileLines);
        int scenicScore = this.getMaxScenicScore(grid);
        return Integer.toString(scenicScore);
    }


    /**
     * Creates an integer grid from the puzzle input.
     * The position (x,y) is accessed using grid[y][x].
     *  
     * @param lines the input file lines
     * @return the integer grid
     */
    private int[][] createGrid(String[] lines) {
        int[][] grid = new int[lines[0].length()][lines.length];
        for (int i=0; i < lines.length; i++) {
            String line = lines[i];
            char[] chars = line.toCharArray();
            for (int j=0; j < chars.length; j++) {
                String charString = Character.toString(chars[j]);
                grid[i][j] = Integer.parseInt(charString);
            }
        }
        return grid;
    }

    /**
     * Returns the number of trees visible from the edge of the grid.
     * 
     * @param grid the grid of tree heights
     * @return the number of visible trees
     */
    private int countVisibleTrees(int[][] grid) {
        int visibleTrees = 0;
        for (int y=0; y < grid.length; y++) {
            for (int x=0; x < grid[y].length; x++) {
                if (this.canTreeBeSeenFromEdge(grid, x, y)) {
                    visibleTrees++;
                }
            }
        }
        return visibleTrees;
    }

    /**
     * Returns if a given tree can be seen from the edge of the grid.
     * 
     * @param grid the grid of tree heights
     * @param x the x position of the tree
     * @param y the y position of the tree
     * @return true if the tree can be seen from the edge, false otherwise
     */
    private boolean canTreeBeSeenFromEdge(int[][] grid, int x, int y) {
        boolean canBeSeen = false; // assume the tree cannot be seen
        int upViewable = this.getUpDistanceViewable(grid, x, y);
        int downViewable = this.getDownDistanceViewable(grid, x, y);
        int leftViewable = this.getLeftDistanceViewable(grid, x, y);
        int rightViewable = this.getRightDistanceViewable(grid, x, y);
        canBeSeen = canBeSeen || (upViewable == y);
        canBeSeen = canBeSeen || (downViewable == ((grid.length - 1) - y));
        canBeSeen = canBeSeen || (leftViewable == x);
        canBeSeen = canBeSeen || (rightViewable == ((grid[y].length - 1) - x));
        return canBeSeen;
    }

    /**
     * Returns the distance viewable upwards.
     * 
     * @param grid the tree height grid
     * @param treeX the tree's X position in the grid
     * @param treeY the tree's Y position in the grid
     * @return the distance viewable
     */
    private int getUpDistanceViewable(int[][] grid, int treeX, int treeY) {
        return this.getDistanceViewable(grid, treeX, treeY, 0, -1);
    }

    /**
     * Returns the distance viewable downwards.
     * 
     * @param grid the tree height grid
     * @param treeX the tree's X position in the grid
     * @param treeY the tree's Y position in the grid
     * @return the distance viewable
     */
    private int getDownDistanceViewable(int[][] grid, int treeX, int treeY) {
        return this.getDistanceViewable(grid, treeX, treeY, 0, 1);
    }

    /**
     * Returns the distance viewable to the left.
     * 
     * @param grid the tree height grid
     * @param treeX the tree's X position in the grid
     * @param treeY the tree's Y position in the grid
     * @return the distance viewable
     */
    private int getLeftDistanceViewable(int[][] grid, int treeX, int treeY) {
        return this.getDistanceViewable(grid, treeX, treeY, -1, 0);
    }

    /**
     * Returns the distance viewable to the right.
     * 
     * @param grid the tree height grid
     * @param treeX the tree's X position in the grid
     * @param treeY the tree's Y position in the grid
     * @return the distance viewable
     */
    private int getRightDistanceViewable(int[][] grid, int treeX, int treeY) {
        return getDistanceViewable(grid, treeX, treeY, 1, 0);
    }


    /**
     * Returns the distance viewable along a line in the grid.
     * The line is set using the xStep and yStep parameters and always passes through (treeX,treeY).
     * 
     * @param grid the tree height grid
     * @param treeX the X position of the tree
     * @param treeY the Y position of the tree
     * @param xStep the x step, should be 1, 0 or -1
     * @param yStep the y step, should be 1, 0 or -1
     * @return the distance viewable along the line
     */
    private int getDistanceViewable(int[][] grid, int treeX, int treeY, int xStep, int yStep) {
        int distance = 0;
        // intitalise the loop variables to be the first position to be checked
        int x = treeX + xStep;
        int y = treeY + yStep;
        while ((y >= 0) && (y < grid.length) && (x >= 0) && (x < grid[y].length)) {
            // while (x, y) is in the grid
            if (grid[y][x] >= grid[treeY][treeX]) {
                // tree is blocked by (x,y) - return the distance
                return distance;
            }
            distance++; // the tree wasn't blocked - increment the viewable distance
            // increment the loop variables
            x += xStep;
            y += yStep;
        }
        // reached the edge - return the score
        return distance;
    }


    /**
     * Returns the maximum scenic score for the tree grid.
     * 
     * @param grid the tree height grid
     * @return the maximum scenic score
     */
    private int getMaxScenicScore(int[][] grid) {
        int maxScore = 0;
        for (int y=0; y < grid.length; y++) {
            for (int x=0; x < grid[y].length; x++) {
                int score = this.getScenicScore(grid, x, y);
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }
        return maxScore;
    }


    /**
     * Returns the scenic score for a given tree.
     * 
     * @param grid the tree height grid
     * @param x the tree's X position
     * @param y the tree's Y position
     * @return the tree's scenic score
     */
    private int getScenicScore(int[][] grid, int x, int y) {
        int score = 1; 
        int upViewable = this.getUpDistanceViewable(grid, x, y);
        int downViewable = this.getDownDistanceViewable(grid, x, y);
        int leftViewable = this.getLeftDistanceViewable(grid, x, y);
        int rightViewable = this.getRightDistanceViewable(grid, x, y);
        if (!(upViewable == y)) upViewable++;
        if (!(downViewable == ((grid.length - 1) - y))) downViewable++;
        if (!(leftViewable == x)) leftViewable++;
        if (!(rightViewable == ((grid[y].length - 1) - x))) rightViewable++;
        score *= upViewable;
        score *= downViewable;
        score *= leftViewable;
        score *= rightViewable;
        return score;
    }
    
}
