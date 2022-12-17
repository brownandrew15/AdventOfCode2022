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
        return "";
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
        return this.isTreeSeenAlongX(grid, x, y, +1)
                || this.isTreeSeenAlongX(grid, x, y, -1)
                || this.isTreeSeenAlongY(grid, x, y, +1)
                || this.isTreeSeenAlongY(grid, x, y, -1);     
    }

    /**
     * Returns if the tree can be seen from along the y axis.
     * 
     * @param grid the tree height grid
     * @param treeX the x position of the tree
     * @param treeY the y position of the tree
     * @param xStep the amount to step the x value by, should be +1 or -1
     * @return true if the tree can be seen, false otherwise
     */
    private boolean isTreeSeenAlongY(int[][] grid, int treeX, int treeY, int xStep) {
        return this.isTreeSeenFromDirection(grid, treeX, treeY, xStep, 0);
    }

    /**
     * Returns if the tree can be seen from along the x axis.
     * 
     * @param grid the tree height grid
     * @param treeX the x position of the tree
     * @param treeY the y position of the tree
     * @param yStep the amount to step the y value by, should be +1 or -1
     * @return true if the tree can be seen, false otherwise
     */
    private boolean isTreeSeenAlongX(int[][] grid, int treeX, int treeY, int yStep) {
        return this.isTreeSeenFromDirection(grid, treeX, treeY, 0, yStep);
    }

    /**
     * Returns if the tree can be seen along a given line
     * 
     * @param grid the tree height grid
     * @param treeX the x position of the tree
     * @param treeY the y position of the tree
     * @param xStep the amount to step the x value by, should be +1, 0 or -1
     * @param yStep the amount to step the y value by, should be +1, 0 or -1
     * @return true if the tree can be seen, false otherwise
     */
    private boolean isTreeSeenFromDirection(int[][] grid, int treeX, int treeY, int xStep, int yStep) {
        // intitalise the loop variables to be the first position to be checked
        int x = treeX + xStep;
        int y = treeY + yStep;
        while ((y >= 0) && (y < grid.length) && (x >= 0) && (x < grid[y].length)) {
                // while (x, y) is in the grid
                if (grid[y][x] >= grid[treeY][treeX]) {
                    // tree is blocked by (x,y)
                    return false;
                }
            // increment the loop variables
            x += xStep;
            y += yStep;
        }
        // no trees blocked the current tree - return that the tree can be seen
        return true;
    }

}
