package org.example.ArrayListAssignment;

public class ParaStack<T> {

    private ObjectArrayList list;

    public ParaStack() {
        list = new ObjectArrayList();
    }

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        System.out.println(list.size());
        return (T) list.remove(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
