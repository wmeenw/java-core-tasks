package task2;

public interface DynamicArray {
    int size();
    boolean isEmpty();
    boolean contains(int element);
    boolean add(int e);
    boolean containsAll(DynamicIntArray c);
    boolean addAll(DynamicIntArray c);
    boolean addAll(int index, DynamicIntArray c);
    boolean removeAll(DynamicIntArray c);
    boolean retainAll(DynamicIntArray c);
    default void sort(){

    }
    void clear();
    int get(int index);
    int set(int index, int element);
    void add(int index, int element);
    int remove(int index);
    int indexOf(int element);
    int lastIndexOf(int element);
}

