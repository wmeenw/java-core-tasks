package task2;

import java.util.Arrays;

public class DynamicIntArray implements DynamicArray {
    private static final int defaultCapacity = 10;
    private int[] data;
    private int size;

    public DynamicIntArray(){
        this.data = new int[defaultCapacity];
        this.size = 0;
    }

    private void isEnoughCapacity(int capacity){
        if (capacity > data.length){
            int newCapacity = data.length * 2;
            if (newCapacity < capacity){
                newCapacity = capacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    @Override
    public boolean add(int e) {
        isEnoughCapacity(size + 1);
        data[size] = e;
        size += 1;
        return true;
    }

    @Override
    public boolean containsAll(DynamicIntArray c) {
        for (int i = 0; i < c.size(); ++i){
            if (!contains(c.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(DynamicIntArray c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, DynamicIntArray c) {
        if (c.size() == 0) return false;
        isEnoughCapacity(size + c.size());
        System.arraycopy(data, index, data, index + c.size(), size - index);
        for (int i = 0; i < c.size(); ++i){
            data[index + i] = c.get(i);
        }
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(DynamicIntArray c) {
        boolean removed = false;
        for (int i = 0; i < c.size(); ++i){
            int el = c.get(i);
            int index = indexOf(el);
            while (index != -1){
                remove(index);
                index = indexOf(el);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean retainAll(DynamicIntArray c) {
        boolean retained = false;
        for (int i = size - 1; i >= 0; --i){
            if (!c.contains(data[i])){
                remove(i);
                retained = true;
            }
        }
        return retained;
    }

    @Override
    public void sort() {
        Arrays.sort(data, 0, size);
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + "but size: " + size);
        }
        return data[index];
    }

    @Override
    public int set(int index, int element) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + "but size: " + size);
        }
        int was = data[index];
        data[index] = element;
        return was;
    }

    @Override
    public void add(int index, int element) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + "but size: " + size);
        }
        isEnoughCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size += 1;
    }

    @Override
    public int remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + "but size: " + size);
        }
        int removed = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size -= 1;
        return removed;
    }

    @Override
    public int indexOf(int element) {
        for (int i = 0; i < size; ++i){
            if (data[i] == element){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; --i){
            if (data[i] == element){
                return i;
            }
        }
        return -1;
    }
}
