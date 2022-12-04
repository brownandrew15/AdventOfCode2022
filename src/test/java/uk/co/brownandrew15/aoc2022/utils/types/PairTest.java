package uk.co.brownandrew15.aoc2022.utils.types;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
