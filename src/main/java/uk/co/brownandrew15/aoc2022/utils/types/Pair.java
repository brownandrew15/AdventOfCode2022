package uk.co.brownandrew15.aoc2022.utils.types;

/**
 * Class to hold a pair of values.
 */
public class Pair<T, U> {

    private T left;
    private U right;
    
    /**
     * Constructs a pair object.
     * 
     * @param left the left value
     * @param right the right value
     */
    public Pair(T left, U right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the left value.
     * 
     * @return the left value
     */
    public T getLeft() {
        return this.left;
    }

    /**
     * Returns the right value.
     * 
     * @return the right value
     */
    public U getRight() {
        return this.right;
    }


    public String toString() {
        return "(" + this.left.toString() + "," + this.right.toString() + ")";
    }

}
