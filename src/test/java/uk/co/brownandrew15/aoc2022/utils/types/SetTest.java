package uk.co.brownandrew15.aoc2022.utils.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetTest {
    
    private Set<Integer> set;

    @BeforeEach
    public void setup() {
        this.set = new Set<Integer>();
    }

    /**
     * Tests that the newly constructed set is empty.
     */
    @Test
    public void testNewIsEmpty() {
        assertEquals(0, this.set.size(), "The newly created set was not empty");
    }

    /**
     * Tests that an item can be added to the set.
     */
    @Test
    public void testAddItem() {
        this.set.add(1);
        assertEquals(1, this.set.size(), "The set size did not increase to 1 after an item was added");
    }

    /**
     * Tests that the set does not contain an element that was not added.
     */
    @Test
    public void testContainsNotContains() {
        assertFalse(this.set.contains(1), "The set contains an element that was not added");
    }

    /**
     * Tests that the set contains an element that was added.
     */
    @Test
    public void testContainsContains() {
        this.set.add(1);
        assertTrue(this.set.contains(1), "The set did not contain an element that was added");
    }

    /**
     * Tests that if an element is added that the set already contains, the size does not increase.
     */
    @Test
    public void testAddDuplicate() {
        this.set.add(1);
        int size = this.set.size();
        this.set.add(1);
        int newSize = this.set.size();
        assertEquals(size, newSize, "The set size did not remain at 1 when duplicate items were added");
    }

    /**
     * Tests that an element can be removed.
     */
    @Test
    public void testRemove() {
        this.set.add(1);
        this.set.remove(1);
        assertFalse(this.set.contains(1), "The set contains an element that was removed");
    }


    /**
     * Tests that the string representation is correct.
     */
    @Test
    public void testToString() {
        this.set.add(1);
        this.set.add(2);
        String str = this.set.toString();
        assertEquals("{1,2}", str, "The string representation of the set was not the expected value");
    }

}
