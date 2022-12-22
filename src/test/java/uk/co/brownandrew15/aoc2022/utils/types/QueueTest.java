package uk.co.brownandrew15.aoc2022.utils.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTest {
    
    private Queue<Integer> queue;

    @BeforeEach
    public void setup() {
        this.queue = new Queue<Integer>();
    }


    /**
     * Tests that a newly constructed queue object has a length of 0.
     */
    @Test
    public void testNewQueueIsEmpty() {
        assertEquals(0, this.queue.length(), "The new queue was not empty");
    }

    /**
     * Tests that the length of the queue increased to 1 after an elememt was added.
     */
    @Test 
    public void testAddItem() {
        this.queue.add(1);
        assertEquals(1, this.queue.length(), "The queue length was not 1 after a single element was added");
    }

    /**
     * Tests that the length of the queue is zero after an element is added and removed.
     */
    @Test 
    public void testLengthAfterAddAndRemove() {
        this.queue.add(1);
        this.queue.remove();
        assertEquals(0, this.queue.length(), "The length of the queue did not return to 0 after an element was added and removed");
    }

    /**
     * Tests that null is returned when the queue is empty.
     */
    @Test
    public void testNullReturnedWhenEmpty() {
        assertNull(this.queue.remove());
    }

    /**
     * Tests that the value returned is the value that was added.
     */
    @Test
    public void testReturnedValueAfterRemove() {
        this.queue.add(1);
        assertEquals(1, this.queue.remove(), "The value returned was not the expected value");
    }

    /**
     * Tests that the value returned after two elements are added and one is removed is the correct value.
     */
    @Test
    public void testSecondReturn() {
        this.queue.add(1);
        this.queue.add(2);
        this.queue.remove();
        assertEquals(2, this.queue.remove(), "The value returned was not the expected value");
    }

    /**
     * Tests that the string representation is correct.
     */
    @Test
    public void testToString() {
        this.queue.add(1);
        this.queue.add(2);
        String str = this.queue.toString();
        assertEquals("[1<2]", str, "The string representation of the queue was not the expected value");
    }

}
