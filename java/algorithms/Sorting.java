package algorithms;

import java.util.ArrayList;

public class Sorting {
    // Selection sort for static array
    public int[] selectionSort(int[] arr) {
        // loop to traverse the array
        for (int element = 1; element < arr.length; element++) {
            // setting the initial maximum value
            int maxValueIndex = 0;

            // loop to compare values at each index while traversing
            for (int i = 1; i < arr.length - element; i++) {
                // condition to compare values
                if (arr[maxValueIndex] < arr[i]) {
                    // setting the index of highest value after comparing
                    maxValueIndex = i;
                }
            }
            // swapping values
            int holder = arr[maxValueIndex];
            arr[maxValueIndex] = arr[arr.length - element];
            arr[arr.length - element] = holder;
        }
        // returning a sorted array
        return arr;
    }

    // Selection sort for dynamic arrayList
    public ArrayList<Integer> selectionSort(ArrayList<Integer> arrayList) {
        // loop to traverse the array
        for (int element = 1; element < arrayList.size(); element++) {
            // setting the initial maximum value
            int maxValueIndex = 0;

            // loop to compare values at each index while traversing
            for (int i = 1; i < arrayList.size() - element; i++) {
                // condition to compare values
                if (arrayList.get(maxValueIndex) < arrayList.get(i)) {
                    // setting the index of highest value after comparing
                    maxValueIndex = i;
                }
            }
            // swapping values
            int holder = arrayList.get(maxValueIndex);
            arrayList.set(maxValueIndex, arrayList.get(arrayList.size() - element));
            arrayList.set(arrayList.size() - element, holder);
        }
        // returning a sorted array
        return arrayList;
    }

    // Bubble sort for static arrays, sorting by the largest value
    public int[] bubbleSort(int[] arr) {
        // loop to traverse the array
        for (int elements = 0; elements < arr.length; elements++) {
            // loop to traverse from the beginning of the array while comparing values
            for (int i = 0; i < arr.length - 1 - elements; i++) {
                // condition to check if the swapping is necessary
                if (arr[i] > arr[i + 1]) {
                    // swapping
                    int holder = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = holder;
                }
            }
        }
        // returning the sorted array
        return arr;
    }

    // Bubble sort for dynamic arrayLists, sorting by the largest value
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> arrayList) {
        // loop to traverse the array
        for (int elements = 0; elements < arrayList.size(); elements++) {
            // loop to traverse from the beginning of the array while comparing values
            for (int i = 0; i < arrayList.size() - 1 - elements; i++) {
                // condition to check if the swapping is necessary
                if (arrayList.get(i) > arrayList.get(i + 1)) {
                    // swapping
                    int holder = arrayList.get(i);
                    arrayList.set(i, arrayList.get(i + 1));
                    arrayList.set(i + 1, holder);
                }
            }
        }
        // returning the sorted array
        return arrayList;
    }

    // Merge sort to sort recursively
    // this method is mainly handles the splitting of the array to sub-arrays and
    // prepare
    // to merge which will be handled by another method
    public int[] mergeSort(int[] arr) {

        // if the array has 1 or no elements, it is already sorted
        if (arr.length <= 1) {
            return arr;
        }

        // find the middle index
        int mid = arr.length / 2;

        // split the array into left sub-array with the first half of the elements
        int[] left = new int[mid];
        // split the array into right sub-array with the final half of the elements
        int[] right = new int[arr.length - mid];

        // copy the first half elements into the left sub-array
        System.arraycopy(arr, 0, left, 0, mid);
        // copy the final half elements into the right sub-array
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        // System.arraycopy(src, srcPos, dest, destPos, size)
        // src - main array which is the source that the copy will be based on
        // srcPos - the starting position index of the source array the coping starts
        // dest - the reference that the copied array is assigned to
        // destPos -
        // size - the length/no.of elements being copied

        // call mergeSort to sort the left sub-array
        left = mergeSort(left);
        // call mergeSort to sort the right sub-array
        right = mergeSort(right);
        // at the start the recursive call will be called until there are only one
        // element
        // for both left and right sub-arrays which will then be proceeded to merge
        // while sorting

        // return the sorted and merged array
        return merge(left, right);
    }

    // helper method to merge sub-arrays while sorting
    private int[] merge(int[] left, int[] right) {
        // initializing the new sorted array
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // adding elements to the sorted array comparing the values of the 2 sub-arrays
        while (i < left.length && j < right.length) {
            // adding the value from the left sub-array
            if (left[i] < right[j]) {
                // using post-incrementing to increase the count while using the initial
                // value for the index
                result[k++] = left[i++];

                // adding the value from the right sub-array
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy remaining elements from right array
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }
}