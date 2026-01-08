package data_structures.heaps.max_heap;

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> maxHeap;

    public MaxHeap() {
        this.maxHeap = new ArrayList<>();
    }

    public int getSize() {
        return maxHeap.size();
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
        return maxHeap.get(getLeftChildIndex(parentIndex));
    }

    // getting values
    private int getRightChild(int parentIndex) {
        return maxHeap.get(getRightChildIndex(parentIndex));
    }

    private int getParent(int childIndex) {
        return maxHeap.get(getParentIndex(childIndex));
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
        int temp = maxHeap.get(index2);
        maxHeap.set(index2, maxHeap.get(index1));
        maxHeap.set(index1, temp);
    }

    public int peek() {
        if (getSize() == 0)
            throw new IllegalStateException("Heap is empty");

        return maxHeap.get(0);
    }

    public int poll() {
        if (getSize() == 0)
            throw new IllegalStateException("Heap is empty");

        int maxValue = maxHeap.get(0);
        swap(0, getSize() - 1);
        maxHeap.remove(getSize() - 1);
        heapifyDown(0);
        return maxValue;
    }

    public void add(int value) {
        maxHeap.add(value);
        heapifyUp(getSize() - 1);
    }

    private void heapifyUp(int startIndex) {
        while (hasParent(startIndex)) {
            int parentIndex = getParentIndex(startIndex);

            if (getParent(startIndex) < maxHeap.get(startIndex)) {
                swap(parentIndex, startIndex);
                startIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int startIndex) {
        while (hasLeftChild(startIndex)) {
            int largerChildIndex = getLeftChildIndex(startIndex);

            if (hasRightChild(startIndex) && getRightChild(startIndex) > getLeftChild(startIndex)) {
                largerChildIndex = getRightChildIndex(startIndex);
            }

            if (maxHeap.get(startIndex) >= maxHeap.get(largerChildIndex)) {
                break;
            }

            swap(startIndex, largerChildIndex);
            startIndex = largerChildIndex;
        }
    }
}
