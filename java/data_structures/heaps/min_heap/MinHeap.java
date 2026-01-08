package data_structures.heaps.min_heap;

import java.util.ArrayList;

public class MinHeap {
    ArrayList<Integer> minHeap;

    public MinHeap() {
        this.minHeap = new ArrayList<>();
    }

    public int getSize() {
        return minHeap.size();
    }

    // getting indexes
    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChild(int parentIndex) {
        return minHeap.get(getLeftChildIndex(parentIndex));
    }

    // getting values
    private int getRightChild(int parentIndex) {
        return minHeap.get(getRightChildIndex(parentIndex));
    }

    private int getParent(int childIndex) {
        return minHeap.get(getParentIndex(childIndex));
    }

    // checking if value exists in the index
    private boolean hasLeftChild(int parentIndex) {
        return (getLeftChildIndex(parentIndex) < getSize());
    }

    private boolean hasRightChild(int parentIndex) {
        return (getRightChildIndex(parentIndex) < getSize());
    }

    private boolean hasParent(int childIndex) {
        return (childIndex > 0);
    }

    public void swap(int index1, int index2) {
        int temp = minHeap.get(index2);
        minHeap.set(index2, minHeap.get(index1));
        minHeap.set(index1, temp);
    }

    public int peek() {
        if (getSize() == 0)
            throw new IllegalStateException("Heap is empty");

        return minHeap.get(0);
    }

    public int poll() {
        if (getSize() == 0)
            throw new IllegalStateException("Heap is empty");

        int minValue = minHeap.get(0);
        swap(0, getSize() - 1);
        minHeap.remove(getSize() - 1);
        heapifyDown(0);
        return minValue;
    }

    public void add(int value) {
        minHeap.add(value);
        heapifyUp(getSize() - 1);
    }

    private void heapifyUp(int startIndex) { // used during insertion
        while (hasParent(startIndex)) {
            int parentIndex = getParentIndex(startIndex);

            if (getParent(startIndex) > minHeap.get(startIndex)) {
                swap(parentIndex, startIndex);
                startIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int startIndex) { // used during deletion
        while (hasLeftChild(startIndex)) {
            int smallerChildIndex = getLeftChildIndex(startIndex);

            if (hasRightChild(startIndex) && getRightChild(startIndex) < getLeftChild(startIndex)) {
                smallerChildIndex = getRightChildIndex(startIndex);
            }

            if (minHeap.get(startIndex) <= minHeap.get(smallerChildIndex)) {
                break;
            }

            swap(startIndex, smallerChildIndex);
            startIndex = smallerChildIndex;
        }
    }
}
