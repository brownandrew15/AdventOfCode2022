package uk.co.brownandrew15.aoc2022.utils.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PairTest {

    private Pair<Integer, Integer> pair;
    
    /**
     * Constructs a pair object that contains two integers before each test.
     */
    @BeforeEach
    public void setup() {
        this.pair = new Pair<Integer, Integer>(1,2);
    }

    /**
     * Tests that the left value is returned correctly.
     */
    @Test
    public void testGetLeft() {
        assertEquals(1, this.pair.getLeft(), "The left value was not the expected value");
    }

    /**
     * Tests that the right value is returned correctly.
     */
    @Test
    public void testGetRight() {
        assertEquals(2, this.pair.getRight(), "The right value was not the expected value");
    }

    /**
     * Tests that the string representation is correct.
     */
    @Test
    public void testToString() {
        assertEquals("(1,2)", this.pair.toString(), "The string representation was not the expected representation");
    }

    /**
     * Tests that a set of pairs that are equal are equal.
     */
    @Test
    public void testEqualsEqual() {
        Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>(1,2);
        Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(1,2);
        assertTrue(pair1.equals(pair2), "The equal pairs were not equal");
    }

    /**
     * Tests that a not equal set of pairs are not equal.
     */
    @Test
    public void testEqualsNotEqual() {
        Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>(1,2);
        Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(2,1);
        assertFalse(pair1.equals(pair2), "The not equal pairs were equal");
    }

    /**
     * Tests that the hashcodes for two equal objects are the same.
     */
    @Test
    public void testHashCode() {
        Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>(1,2);
        Pair<Integer, Integer> pair2 = new Pair<Integer, Integer>(1,2);
        assertEquals(pair1.hashCode(), pair2.hashCode(), "The hashcodes were not equal");
    }
    

}
