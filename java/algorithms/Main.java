package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Searching search = new Searching();
        Sorting sort = new Sorting();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(42, 87, 13, 64,
                25, 93, 8, 59, 37, 76));

        int[] arr = { 42, 87, 13, 64, 25, 93, 8, 59, 37, 76 };

        int target = 93;

        // int result = search.linearSearch(target, arr);

        // if (result >= 0) {
        // System.out.printf("Target value %d found at index %d \n", target, result);
        // } else {
        // System.out.println(target + " not found in the array");
        // }

        // result = search.linearSearch(target, arrayList);
        // if (result >= 0) {
        // System.out.printf("Target value %d found at index %d \n", target, result);
        // } else {
        // System.out.println(target + " not found in the array");
        // }

        int result = search.binarySearch(target, arr, true);

        if (result >= 0) {
            System.out.printf("Target value %d found at index %d \n", target, result);
        } else {
            System.out.println(target + " not found in the array");
        }

        // System.out.print("Unsorted Array: ");
        // for (int i : arr) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // int[] sortedArr = sort.selectionSort(arr);

        // System.out.print("Sorted Array: ");
        // for (int i : sortedArr) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // System.out.print("Unsorted Array: ");
        // for (int i : arrayList) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // ArrayList<Integer> sortedArr = sort.selectionSort(arrayList);

        // System.out.print("Sorted Array: ");
        // for (int i : sortedArr) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // System.out.print("Unsorted Array: ");
        // for (int i : arr) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        // int[] sortedArr = sort.bubbleSort(arr);

        // System.out.print("Sorted Array: ");
        // for (int i : sortedArr) {
        // System.out.print(i + " ");
        // }
        // System.out.println();

        int[] sortedArr = sort.bubbleSort(arr);

        System.out.print("Sorted Array: ");
        for (int i : sortedArr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
