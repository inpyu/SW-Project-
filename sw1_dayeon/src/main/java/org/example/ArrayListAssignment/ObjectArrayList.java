package org.example.ArrayListAssignment;

public class ObjectArrayList extends ObjectArrayListLimitedCapacity {
    private static int CAPACITY = 10;

    public ObjectArrayList() {
        super();
    }

    public void add(Object o){
        if(size() == CAPACITY){
            Object[] newArray = new Object[CAPACITY * 2];
            System.arraycopy(array, 0, newArray, 0, CAPACITY);
            array = newArray;
            CAPACITY *= 2;
        }
        array[size()] = o;
        super.add(o);
    }

    public int size() {
        return super.size();
    }

    public boolean contains(Object o) {
        for (Object object : array) {
            if(object == null) {
                break;
            }
            if (object.equals(o)) {
                return true;
            }
        }
        return false;
    }
}
