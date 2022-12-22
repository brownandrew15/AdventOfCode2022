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

    @Override
    public String toString() {
        return "(" + this.left.toString() + "," + this.right.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Pair<?, ?>)) {
            return false;
        }
        @SuppressWarnings("unchecked") Pair<T, U> other = (Pair<T, U>) o;
        return (
            this.getLeft().equals(other.getLeft()) 
            && (this.getRight().equals(other.getRight()))
        );
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.getLeft().hashCode();
        result = 31 * result + this.getRight().hashCode();
        return result;
    }

}
