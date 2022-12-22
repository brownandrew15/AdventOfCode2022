package uk.co.brownandrew15.aoc2022.utils.types;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {

    private List<T> items;

    /**
     * Constructs a Queue object.
     */
    public Queue() {
        this.items = new ArrayList<T>();
    }

    /**
     * Adds an item to the queue.
     * 
     * @param item the item to add to the queue
     */
    public void add(T item) {
        this.items.add(item);
    }

    /**
     * Removes an item from the queue.
     * 
     * @return the item from the front of the queue, null if the queue is empty
     */
    public T remove() {
        if (this.length() < 1) {
            return null;
        }
        T item = this.items.get(0);
        this.items.remove(0);
        return item;
    }

    /**
     * Returns the number of items in the queue.
     * 
     * @return the length of the queue
     */
    public int length() {
        return this.items.size();
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i=0; i < this.items.size(); i++) {
            if (!(i == 0)) {
                str.append("<");
            }
            str.append(this.items.get(i).toString());
        }
        str.append("]");
        return str.toString();
    }

    
}
