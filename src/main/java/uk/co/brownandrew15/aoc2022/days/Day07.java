package uk.co.brownandrew15.aoc2022.days;

import java.util.HashMap;
import java.util.Map;

import uk.co.brownandrew15.aoc2022.Day;
import uk.co.brownandrew15.aoc2022.utils.types.Stack;

/**
 * Class for Day 7.
 */
public class Day07 extends Day {

    public int getDayNumber() {
        return 7;
    }

    public String solvePartOne() {
        Map<String, Integer> dirSizes = this.getDirSizes(this.fileLines);
        int total = this.getSumOfDirsLessThan(dirSizes, 100000);
        return Integer.toString(total);
    }

    public String solvePartTwo() {
        Map<String, Integer> dirSizes = this.getDirSizes(this.fileLines);
        int spaceClear = 70000000 - dirSizes.get("/");
        int smallestDirSizeToDelete = this.getSmallestDirSizeToDelete(dirSizes, 30000000, spaceClear);
        return Integer.toString(smallestDirSizeToDelete);
    }


    /**
     * Returns a map of the dir paths and their sizes from the terminal output.
     * 
     * @param terminalOutput the terminal output lines
     * @return the map of directory paths to their sizes
     */
    private Map<String, Integer> getDirSizes(String[] terminalOutput) {
        Map<String, Integer> sizeMap = new HashMap<String, Integer>();
        Stack<String> dirStack = new Stack<String>();

        for (String output : terminalOutput) {
            if (this.isChangeDir(output)) {
                String newDirName = this.getNewDirName(output);
                if (newDirName.equals("..")) {
                    dirStack.pop();
                } else {
                    dirStack.push(newDirName);
                }
            } else if (this.isListDir(output)) {
                // don't need to do anything for a list dir command
            } else {
                // is list output
                if (!(this.isListDirectoryOutput(output))) {
                    // the list output is a file output with a size
                    int fileSize = this.getFileSize(output);
                    this.addFileSizeToMap(sizeMap, dirStack, fileSize);
                }
            }
        }

        return sizeMap;
    }



    /**
     * Returns if a terminal output line is for a change directory command.
     * 
     * @param terminalOutput the terminal output line
     * @return true if the line is a change directory command, false otherwise
     */
    private boolean isChangeDir(String terminalOutput) {
        return terminalOutput.subSequence(0, 4).equals("$ cd");
    }

    /**
     * Returns if a terminal output line is for a list directory contents command.
     * 
     * @param terminalOutput the terminal output line
     * @return true if the line is for a list directory contents command, false otherwise
     */
    private boolean isListDir(String terminalOutput) {
        return terminalOutput.subSequence(0, 4).equals("$ ls");
    }

    /**
     * Returns the name of the new directory for a change directory command.
     * 
     * @param terminalOutput the change directory command terminal output line
     * @return the name of the new directory
     */
    private String getNewDirName(String terminalOutput) {
        return terminalOutput.split(" ")[2]; // {"$", "cd", "new_dir_name"}
    }

    /**
     * Returns if the output line for a list directory contents is a directory.
     * 
     * @param terminalOutput the list directory output line
     * @return true if the line is for a directory, false otherwise
     */
    private boolean isListDirectoryOutput(String terminalOutput) {
        return (terminalOutput.split(" ")[0].equals("dir"));
    }

    /**
     * Returns the size of a file from the list directory terminal output line.
     * 
     * @param terminalOutput the file output line from the list directory command
     * @return the size of the file
     */
    private int getFileSize(String terminalOutput) {
        return Integer.parseInt(terminalOutput.split(" ")[0]);
    }

    /**
     * Adds the size of the file to the directory sizes map.
     * 
     * @param sizeMap the directory sizes map
     * @param dirStack the current path
     * @param fileSize the size of the file to add
     */
    private void addFileSizeToMap(Map<String, Integer> sizeMap, Stack<String> dirStack, int fileSize) {
        Stack<String> holdingStack = new Stack<String>();

        // add the file size to each level of the filepath
        while (!(dirStack.isEmpty())) {
            String path = this.getStackAsPath(dirStack);
            this.updateMap(sizeMap, path, fileSize);
            holdingStack.push(dirStack.pop());
        }

        // move items back to dirStack
        while (!(holdingStack.isEmpty())) {
            dirStack.push(holdingStack.pop());
        }
    }

    /**
     * Returns the directory stack as a directory path.
     * 
     * @param dirStack the directory stack
     * @return the directory path
     */
    private String getStackAsPath(Stack<String> dirStack) {
        String asString = dirStack.toString();
        asString = asString.replaceAll("\\[", "");
        asString = asString.replaceAll("\\]", "");
        asString = asString.replaceAll(",", "/");
        asString = asString.replaceAll("//", "/");
        return asString;
    }

    /**
     * Updates the map with the new file size.
     * 
     * @param map the map
     * @param key the file path
     * @param value the file size
     */
    private void updateMap(Map<String, Integer> map, String key, int value) {
        if (map.containsKey(key)) {
            int existingValue = map.get(key);
            int newValue = existingValue + value;
            map.put(key, newValue);
        } else {
            map.put(key, value);
        }
    }

    /**
     * Returns the sum of all the directories that are not larger than a limit.
     * 
     * @param dirSizes the directory sizes map
     * @param maxDirSize the maximum directory size
     * @return the sum of the directories with size at most the directory limit
     */
    private int getSumOfDirsLessThan(Map<String, Integer> dirSizes, int maxDirSize) {
        int total = 0;
        for (String path : dirSizes.keySet()) {
            int dirSize = dirSizes.get(path);
            if (dirSize <= maxDirSize) {
                total += dirSize;
            }
        }
        return total;
    }

    /**
     * Returns the size of the smallest directory that can be deleted that will clear enough space for the space required.
     * 
     * @param dirSizes the map of the directory sizes
     * @param spaceRequired the space required to be clear
     * @param spaceClear the current space clear
     * @return the size of the smallest directory that when deleted will leave enough space
     */
    private int getSmallestDirSizeToDelete(Map<String, Integer> dirSizes, int spaceRequired, int spaceClear) {
        int greatestMinSize = dirSizes.get("/");
        for (String path : dirSizes.keySet()) {
            int dirSize = dirSizes.get(path);
            if ((dirSize < greatestMinSize) && ((dirSize + spaceClear) > spaceRequired)) {
                greatestMinSize = dirSize;
            }
        }
        return greatestMinSize;
    }


}
