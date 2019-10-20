package mainClasses;

/**
 * This class creates a list of Object's that uses
 * generics so it can be built using Pizza objects
 * This ArrayList dynamically re-sizes when it fills
 * up
 *
 * @param <TBA> - generics input
 *
 * @author Kylun Robbins
 * @version 06/02/2019
 */
public class ArrayList<TBA extends Comparable> {
    private Object[] data = new Object[100];
    private int numElements = 0;

    /**
     * Generic insert method that only
     * takes an Object as argument and
     * inserts the Object to the end of
     * the ArrayList
     *
     * @param newObject - Object to insert
     */
    public void insert(TBA newObject) {
        data[numElements++] = newObject;
    }

    /**
     * Insert method that inserts the argument
     * object at the given index, method re-sizes
     * if the ArrayLis is full and shifts the data
     * to the right at the index to make room for
     * the new Object
     *
     * @param newObject - Object to insert
     * @param index     - index to insert at
     */
    public void insert(TBA newObject, int index) {
        if(numElements == data.length) {
            resize();
        }
        numElements++;
        shiftRight(index);
        data[index] = newObject;
    }

    /**
     * Removes the element at the given
     * index from the ArrayList, the list
     * then shifts to the left to fill the
     * gap from the removed element, returns
     * the Object that was removed
     *
     * @param index - index where element will be removed
     * @return Object
     */
    public Object remove(int index) {
        Object retVal = data[index];
        shiftLeft(index);
        numElements--;
        return (TBA) retVal;
    }

    /**
     * Returns the size of the
     * current ArrayList
     *
     * @return int
     */
    public int size() {
        return numElements;
    }

    /**
     * Returns true if the ArrayList
     * is empty, and false if not
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return numElements == 0;
    }

    /**
     * Index of method takes in a target
     * Object and searches the ArrayList
     * for that object, if found, returns
     * the index, if not found returns -1
     *
     * @param o - Target object
     * @return int
     */
    public int indexOf(Object o) {
        int retVal = -1;
        for(int i = 0; i < numElements; i++) {
            if(o == data[i]) {
                retVal = i;
            }
        }
        return retVal;
    }

    public TBA get(int index) {
        return (TBA)data[index];
    }

    /**
     * Equals method that returns true if the
     * ArrayList is equal to the argument
     *
     * @param o - Object to compare
     * @return - boolean
     */
    public boolean equals(Object o) {
        if(o == null || !(o instanceof ArrayList)) {        // Null and instance of check
            return false;
        }
        ArrayList that = (ArrayList)o;
        if(this.numElements != that.numElements) {          // If the number of elements are not equal
            return false;                                   // return false
        }
        for(int i = 0; i < this.numElements; i++) {         // If the number of elements are the same
            if(this.data[i] != that.data[i]) {              // compare each element
                return false;
            }
        }
        return true;
    }

    /**
     * To String method that returns a String
     * representation of the Array List
     *
     * @return String
     */
    public String toString() {
        String retVal = "";
        for(int i = 0; i < numElements; i++) {
            retVal += data[i] + "\n";
        }
        return retVal;
    }

    /**
     * Private method that shifts the elements
     * in the ArrayList to the right at a given
     * index, this method is used when inserting
     * an element into the ArrayList at a given
     * index
     *
     * @param end - index to start shift at
     */
    private void shiftRight(int end) {
        for(int i = numElements - 2; i >= end; i--) {
            data[i + 1] = data[i];
        }
    }

    /**
     * Private method that shifts the elements
     * in the ArrayList to the left at a given
     * index, this method is used when removing
     * an element from the list
     *
     * @param start - index to start shift at
     */
    private void shiftLeft(int start) {
        for(int i = start; i < numElements - 1; i++) {
            data[i] = data[i + 1];
        }
    }

    /**
     * Private method that is used to resize the
     * ArrayList when it is full, this allows the
     * ArrayList to become dynamic when this method
     * is correctly used in the insert method,
     */
    private void resize() {
        Object[] temp = new Object[data.length * 2];        // Create new array of size double the original
        for(int i = 0; i < data.length; i++) {              // For each element of the original array
            temp[i] = data[i];                              // copy the elements to the temp array
        }
        data = temp;                                        // Set the original array equal to temp array
    }

    /**
     * Swap method swaps two elements
     * at the given indexes
     * @param index1
     * @param index2
     */
    public void swap(int index1, int index2) {
        Pizza temp = (Pizza)data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
