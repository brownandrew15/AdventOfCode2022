package uk.co.brownandrew15.aoc2022.utils.types;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
    
    private List<T> stack;

    /**
     * Constructs a Stack object.
     */
    public Stack() {
        this.stack = new ArrayList<T>();
    }

    /**
     * Adds a item to the top of the stack.
     * 
     * @param item the item to push onto the stack
     */
    public void push(T item) {
        this.stack.add(item);
    }

    /**
     * Pops an item from the top of the stack.
     * 
     * @return the item from the top of the stack
     */
    public T pop() {
        if (this.stack.size() > 0) {
            T top = this.peek();
            this.stack.remove(this.getSize() - 1);
            return top;
        } else {
            return null;
        }
    }

    /**
     * Returns the item on the top of the stack without removing it.
     * 
     * @return the item from the top of the stack
     */
    public T peek() {
        return this.stack.get(this.getSize() - 1);
    }

    /**
     * Returns the size of the stack.
     * 
     * @return the number of elements on the stack
     */
    public int getSize() {
        return this.stack.size();
    }

    /**
     * Returns if the stack is empty or not.
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return (this.getSize() == 0);
    }

    @Override
    public String toString() {
        String str = "[";
        for (int i=0; i < this.getSize(); i++) {
            if (!(i == 0)) {
                str += ",";
            }
            str += this.stack.get(i);
        }
        return str + "]";
    }


}
