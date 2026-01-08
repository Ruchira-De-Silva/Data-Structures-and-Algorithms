package algorithms;

import java.util.ArrayList;

public class Searching {
    public int linearSearch(int target, int[] arr) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                return index;
            }
        }
        return -1;
    }

    public int linearSearch(int target, ArrayList<Integer> arr) {
        for (int index = 0; index < arr.size(); index++) {
            if (arr.get(index) == target) {
                return index;
            }
        }
        return -1;
    }

    public int binarySearch(int target, int[] arr, boolean toSort) {
        // sorting the array if not sorted
        if (toSort) {
            Sorting sort = new Sorting();
            arr = sort.bubbleSort(arr);
            System.out.println("Sorted");

            System.out.print("Sorted Array: ");
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        int low = 0; // minimum index in the search range
        int high = arr.length - 1; // maximum index in the search range

        // loops until the index of start of the range is equal or greater in magnitude
        // than the end of the range
        while (low <= high) {
            // get the middle index of the range
            int mid = low + (high - low) / 2;
            // What if the value after dividing by 2 has .5
            // this is not possible as by default java truncates (dropping the decimal
            // value) the result

            // condition to check if target and mid values match
            if (arr[mid] == target) {
                // returning the index with the target value when condition is true
                return mid;
                // condition to check if the target value is in the section with lower magnitude
                // opposed to the mid point value
            } else if (arr[mid] > target) {
                // setting a new upper border to the range if the target value is less than the
                // mid point value
                high = mid - 1;
            } else {
                // setting a new lower border to the range if the target value is more than the
                // mid point value
                low = mid + 1;
            }
        }
        // returning value if no matches are found in the search
        return -1;
    }

    public int binarySearch(int target, int[] arr) {
        int low = 0; // minimum index in the search range
        int high = arr.length - 1; // maximum index in the search range

        // loops until the index of start of the range is equal or greater in magnitude
        // than the end of the range
        while (low <= high) {
            // get the middle index of the range
            int mid = low + (high - low) / 2;
            // What if the value after dividing by 2 has .5
            // this is not possible as by default java truncates (dropping the decimal
            // value) the result
            // Why can't the calculation be --> (low + high) / 2?
            // This is due to the data type limitation in extreme cases since in an extreme
            // case
            // like if low = 1_500_000_000 and high = 2_000_000_000 the summation will be
            // 3_500_000_000
            // which is above the maximum threshold of the int data type hence the equation
            // above
            // which can avoid this type of situation is used.

            // condition to check if target and mid values match
            if (arr[mid] == target) {
                // returning the index with the target value when condition is true
                return mid;
                // condition to check if the target value is in the section with lower magnitude
                // opposed to the mid point value
            } else if (arr[mid] > target) {
                // setting a new upper border to the range if the target value is less than the
                // mid point value
                high = mid - 1;
            } else {
                // setting a new lower border to the range if the target value is more than the
                // mid point value
                low = mid + 1;
            }
        }
        // returning value if no matches are found in the search
        return -1;
    }
}