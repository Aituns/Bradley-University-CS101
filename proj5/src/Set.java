/*************************************************************** 
<Austin Bennett> 
<Set.java> 
<Project 5> 
<This code contains various method to manipulate and get data from a set> 
***************************************************************/ 

import java.util.ArrayList;
import java.lang.ClassCastException;

public class Set {

    ArrayList<Integer> _set_array;

    // Default Contructor
    public Set() {
        int capacity = 20; //Sets a capacity for the set.
        _set_array = new ArrayList<Integer>(capacity); //makes a new array that's the size of capacity
    }
    
    // Constructor with a paramater for the size
    public Set(int size) {
        _set_array = new ArrayList<Integer>(size); //New array with the size of the input parameter
    }

    // Contructor with a parameter for the lowest and highest
    public Set(int low, int high) {
        int size = (high - low) + 1; // Makes the size of the the array
        _set_array = new ArrayList<Integer>(size);
        for (int i = low; i <= high; i++) {
            _set_array.add(i); //makes the array
        }

    }

    // Adds Integer o to the set if it in not in the set
    public boolean add(Integer o) {
        int capacity = this.size();
        if (o == null) // if o is null return false
            return false;
        if (_set_array.size() == 0) { // if array is empty just add it in
            _set_array.add(o);
            return true;
        }
        int index = -1;
        for (int i = 0; i < _set_array.size(); i++) { // checks for o in the Set and if not adds it and returns true
            if (_set_array.get(i) == o)
                return false;
            if (_set_array.get(i) > o) {
                index = i;
                break;
            }
        }
        if (_set_array.size() == capacity) { // If the set is at capacity, Increase it
            capacity++;
            _set_array.ensureCapacity(capacity);
        }
        //adds Integer o
        if (index != -1)
            _set_array.add(index, o);
        else
            _set_array.add(o);
        return true;
    }
    
    // adds all the elements of s to this set
    public int add(Integer[] s) {
        int successes = 0;
        
        if(s != null) { // makes sure s isn't empty
            for (int i = 0; i < s.length; i++) { // loops through s and uses the add method to add it to this set
                    if(add(s[i]))
                        successes++;
                
            }
        }
        return successes;
    }
    
    // removes element o from this set
    public Integer remove(Integer o) {
        if (_set_array.remove(o)) //removes o from the set and returns the value
            return o;
        else
            return null;
    }
    
    // removes all elements of s from this set
    public Integer remove(Set s) {
        int deleted = 0;
        if (s != null) {
            for(int i = 0; i < s.size(); i++) {
                if(remove(s.get(i)) != null)
                    deleted++;
            }
        }
        return deleted;
    }
    
    // Checks if Integer o is in this set
    public boolean contains(Integer o) {
        if (_set_array.contains(o)) // if o is in this set it returns true
            return true;
        else
            return false;
    }
    
    // Clears the set
    public void clear() {
        _set_array.clear();
    }
    
    // Checks to see if the set is empty
    public boolean isEmpty() {
        if (_set_array.size() == 0) //if the .size is 0 the set is empty
            return true;
        else
            return false;    
    }
    
    // Returns the size of the set
    public int size() {
        return _set_array.size(); // Gets the size
    } 

    // returns the Integer at index
    public Integer get(int index) {
        if (index < 0 || index > _set_array.size()) { // make sure the array is positve and the index is valid
            return null;
        } else {
            return _set_array.get(index); // gets the value at index
        }
    }

    // merges two sets
    public Set union(Set s) {
        Set newSet = new Set(); // set to return 
        if (s == null) // if s is null return just this set
            return this;
        for(int i = 0; i < this.size(); i++) { // adds all of this set
            newSet.add(this.get(i));
        }
        for(int i = 0; i < s.size(); i++) { // adds all of s
            newSet.add(s.get(i));
        }
        return newSet;
    }

    // returns a set with only the 
    public Set intersection(Set s) {
        Set newSet = new Set();
        if (s == null) // if s is null return an empty set
            return newSet;
        if(this.size() < s.size()) { // if statement to decide how to loop
            for (int i = 0; i < this.size(); i++) { // loops and checks for similariteis
                if (s.contains(this.get(i))) 
                    newSet.add(this.get(i));
            }
        } else {
            for (int i = 0; i < s.size(); i++) { // loops and checks for siliarities
                if (this.contains(s.get(i)))
                    newSet.add(s.get(i));
            }
        }
        return newSet;
    }

    // determines if this set is a subset of s
    public boolean subset(Set s) {
        if (s == null) {
            return true;
        } else {
            if ((intersection(s)).equals(s)) { // uses the intersection method to cheeck
                return true;
            } else {
                return false;
            }
        }
    }

    // determines if this set is a superset of s
    public boolean superset(Set s) {
        if (s == null) {
            return false;
        } else if (s.subset(this)) { // uses the subset method to check
            return true;
        } else {
            return false;
        }
    }

    //Supplied
    public String toString() {
        String ret_string = "";

        for (int i = 0; i < _set_array.size(); i++) {
            Integer x = _set_array.get(i);
            String xStr = x == null ? "null" : x.toString();
            ret_string += xStr + (i != _set_array.size() - 1 ? " " : "");
        }

        return ret_string;
    }

    //Supplied
    public boolean equals(Object o) throws ClassCastException {
        if (!(o instanceof Set)) {
            throw new ClassCastException();
        }

        Set s = (Set) (o);

        for (int i = 0; i < _set_array.size(); i++) {
            if (!s.contains(_set_array.get(i))) {
                return false;
            }
        }

        for (int i = 0; i < s.size(); i++) {
            if (!_set_array.contains(s.get(i))) {
                return false;
            }
        }

        return true;
    }
}