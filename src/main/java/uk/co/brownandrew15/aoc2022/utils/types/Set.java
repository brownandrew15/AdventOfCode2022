package uk.co.brownandrew15.aoc2022.utils.types;

import java.util.ArrayList;
import java.util.List;

public class Set<T> {
    
    private List<T> items;

    /**
     * Constructs a set object.
     */
    public Set() {
        this.items = new ArrayList<T>();
    }

    /**
     * Returns if the set contains an item.
     * 
     * @param item the item to check for
     * @return true if the set contains the item, false otherwise
     */
    public boolean contains(T item) {
        return this.items.contains(item);
    }

    /**
     * Adds an item to the set.
     * 
     * @param item the item to add
     */
    public void add(T item) {
        if (!(this.contains(item))) {
            this.items.add(item);
        }
    }

    /**
     * Removes an item from the set.
     * 
     * @param item the item to remove
     * @return true if the item was removed, false otherwise
     */
    public boolean remove(T item) {
        return this.items.remove(item);
    }

    /**
     * Returns the number of items in the set.
     * 
     * @return the number of items in the set
     */
    public int size() {
        return this.items.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i=0; i < this.items.size(); i++) {
            if (!(i == 0)) {
                str.append(",");
            }
            str.append(this.items.get(i).toString());
        }
        str.append("}");
        return str.toString();
    }

}
