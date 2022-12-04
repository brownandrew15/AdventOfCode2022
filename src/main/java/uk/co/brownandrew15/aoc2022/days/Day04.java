package uk.co.brownandrew15.aoc2022.days;

import uk.co.brownandrew15.aoc2022.Day;
import uk.co.brownandrew15.aoc2022.utils.types.Pair;

/**
 * Class for Day 4.
 */
public class Day04 extends Day {
    
    public int getDayNumber() {
        return 4;
    }

    public String solvePartOne() {
        int overlaps = 0;
        for (int i=0; i < this.fileLines.length;i++) {
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> ranges = this.getRanges(this.fileLines[i]);
            if (this.doRangesOverlapFully(ranges.getLeft(), ranges.getRight())) {
                overlaps++;
            }
        }
        return Integer.toString(overlaps);
    }

    public String solvePartTwo() {
        int overlaps = 0;
        for (int i=0; i < this.fileLines.length;i++) {
            Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> ranges = this.getRanges(this.fileLines[i]);
            if (this.doRangesOverlap(ranges.getLeft(), ranges.getRight())) {
                overlaps++;
            }
        }
        return Integer.toString(overlaps);
    }


    /**
     * Processes the assignment string into a pair of range pairs.
     * 
     * @param assignments the assignment string in the format X-Y,A-B
     * @return the pair of ranges
     */
    private Pair<Pair<Integer, Integer>, Pair<Integer, Integer>> getRanges(String assignments) {
        String[] pairData = assignments.split(",");
        Pair<Integer, Integer> first = this.getRange(pairData[0]);
        Pair<Integer, Integer> second = this.getRange(pairData[1]);
        return new Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>(first, second);
    }

    /**
     * Returns the pair containing the range.
     * 
     * @param rangeString the range string in the format A-B
     * @return the pair containing the range
     */
    private Pair<Integer, Integer> getRange(String rangeString) {
        String[] rangeArray = rangeString.split("-");
        int start = Integer.parseInt(rangeArray[0]);
        int end = Integer.parseInt(rangeArray[1]);
        return new Pair<Integer,Integer>(start, end);
    }

    /**
     * Returns if the ranges overlap fully.
     * 
     * @param first the first range
     * @param second the second range
     * @return true if the ranges overlap fully, false otherwise
     */
    private boolean doRangesOverlapFully(Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        boolean firstContainsSecond = (first.getLeft() <= second.getLeft()) && (first.getRight() >= second.getRight());
        boolean secondContainsFirst = (second.getLeft() <= first.getLeft()) && (second.getRight() >= first.getRight());
        return (firstContainsSecond || secondContainsFirst);
    }

    /**
     * Returns if the ranges overlap.
     * 
     * @param first the first range
     * @param second the second range
     * @return true if the ranges overlap, false otherwise
     */
    private boolean doRangesOverlap(Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        boolean firstStartsInSecond = (second.getLeft() <= first.getLeft()) && (first.getLeft() <= second.getRight());
            // second.left <= first.left <= second.right
        boolean firstEndsInSecond = (second.getLeft() <= first.getRight()) && (first.getRight() <= second.getRight());
            // second.left <= first.right <= second.right
        boolean secondStartsInFirst = (first.getLeft() <= second.getLeft()) && (second.getLeft() <= first.getRight());
            // first.left <= second.left <= first.right
        boolean secondEndsInFirst = (first.getLeft() <= second.getRight()) && (second.getRight() <= first.getRight());
            // first.left <= second.right <= first.right
        return (firstStartsInSecond || firstEndsInSecond || secondStartsInFirst || secondEndsInFirst);
    }

}
