package uk.co.brownandrew15.aoc2022.utils.types;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StackTest {

    private Stack<Integer> stack;
    
    /**
     * Constructs a new stack object that stores integers before each test.
     */
    @BeforeEach
    public void setup() {
        this.stack = new Stack<Integer>();
    }

    /**
     * Tests that the stack has a size of 0 after construction.
     */
    @Test
    public void testNewStackGetSize() {
        assertEquals(0, this.stack.getSize(), "The size of the stack was not 0 after construction");
    }

    /**
     * Tests that the stack size increases to 1 after a single element is pushed.
     */
    @Test
    public void testStackSizeAfterPush() {
        this.stack.push(1);
        assertEquals(1, this.stack.getSize(), "The size of the stack was not 1 after a single element was pushed");
    }

    /**
     * Tests the peek method returns the value on the top of the stack.
     */
    @Test
    public void testPeekReturn() {
        this.stack.push(1);
        int topElement = this.stack.peek();
        assertEquals(1, topElement, "The top element was not the last element pushed onto the stack");
        
    }

    /**
     * Tests that peeking at the top of the stack does not change the stack.
     */
    @Test
    public void testPeekDoesNotRemove() {
        this.stack.push(1);
        int topElement = this.stack.peek();
        assertEquals(topElement, this.stack.peek(), "The top element changed after the top element was peeked");
    }

    /**
     * Tests that the stack pops the element that was last pushed to the stack.
     */
    @Test
    public void testPopReturn() {
        this.stack.push(1);
        int returnValue = this.stack.pop();
        assertEquals(1, returnValue, "The value popped off the stack was not the last element to be pushed");
    }

    /**
     * Tests that if an element is popped, then the previously pushed element is now on the top.
     */
    @Test
    public void testPopDoesRemove() {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.pop();
        assertEquals(1, this.stack.peek(), "The element on the top of the stack was not the expected value");
    }

    /**
     * Tests that the stack updates correctly when elements are pushed and popped.
     */
    @Test
    public void testPushThenPopThenPush() {
        this.stack.push(1);
        this.stack.pop();
        this.stack.push(2);
        assertEquals(2, this.stack.peek(), "The top element was not the expected element");
    }

    /**
     * Tests that the newly constructed stack is empty.
     */
    @Test
    public void testEmptyStackIsEmpty() {
        assertTrue(this.stack.isEmpty(),"The new stack is not empty");
    }

    /**
     * Tests that a stack that has elements pushed to it but not popped is not empty.
     */
    @Test
    public void testPushedStackIsNotEmpty() {
        this.stack.push(1);
        assertFalse(this.stack.isEmpty(), "The stack containing elements was not not empty");
    }

    /**
     * Tests that a stack that has had elements pushed to it and then all popped is empty.
     */
    @Test
    public void testPoppedEmptyStackIsEmpty() {
        this.stack.push(1);
        this.stack.pop();
        assertTrue(this.stack.isEmpty(), "The empty stack that has had elements pushed and popped was not empty");
    }


    @Test
    public void testToString() {
        this.stack.push(1);
        this.stack.push(2);
        assertEquals("[1,2]", this.stack.toString(), "The string representation of the stack was not the expected value");
    }

}