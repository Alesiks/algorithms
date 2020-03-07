package by.bsu.mmf.datastructure.heap;

import java.util.ArrayList;
import java.util.List;

// minimum heap (binary)
public class Heap {

    protected List<Integer> data = new ArrayList<>();

    protected int size;

    public int getSize() {
        return size;
    }

    public int getRoot() {
        return data.get(0);
    }

    public void add(int value) {
        data.add(value);
        size++;
        if(size > 1) {
            heapifyUp(size - 1);
        }
    }

    public int pop() {
        int top = data.get(0);

        size--;
        data.set(0, data.get(size));
        data.remove(size);

        if(size > 1) {
            heapifyDown(0);
        }

        return top;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private void swap(int i, int j) {
        int temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    private void heapifyUp(int newIndex) {
        int parentIndex = getParentIndex(newIndex);
        while (parentIndex >= 0) {
            if(data.get(newIndex) < data.get(parentIndex)) {
                swap(newIndex, parentIndex);
                newIndex = parentIndex;
                parentIndex = getParentIndex(newIndex);
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        while (leftChildIndex < size) {
            int rightChildIndex = getRightChildIndex(index);
            int minIndex = leftChildIndex;
            if(rightChildIndex < size && data.get(rightChildIndex) < data.get(leftChildIndex)) {
                minIndex = rightChildIndex;
            }
            if(data.get(minIndex) < data.get(index)) {
                swap(minIndex, index);
            } else {
                break;
            }
            index = minIndex;
            leftChildIndex = getLeftChildIndex(index);
        }
    }


}
