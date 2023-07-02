package Recursion;

public class SortedArray {
     static int counter = 0;
    static boolean isSorted = true;

    public static boolean issorted(int arr[]) {
        if (arr[0] > arr[arr.length - 1]) {
            return checkArrayDescendingOrder(arr);
        } else {
            return checkArrayAscendingOrder(arr);
        }
    }

    // Check if array is sorted in ascending order
    public static boolean checkArrayAscendingOrder(int arr[]) {
        if (counter == arr.length - 1 || !isSorted) {
            return isSorted;
        }

        if (arr[counter] > arr[counter + 1]) {
            isSorted = false;
        }

        counter++;
        return checkArrayAscendingOrder(arr);
    }

    // Check if array is sorted in descending order
    public static boolean checkArrayDescendingOrder(int arr[]) {
        if (counter == arr.length - 1 || !isSorted) {
            return isSorted;
        }

        if (arr[counter] < arr[counter + 1]) {
            isSorted = false;
        }

        counter++;
        return checkArrayDescendingOrder(arr);
    }

    public static void main(String[] args) {
        // Reset the counter and isSorted before each call to issorted
        counter = 0;
        isSorted = true;
        int[] arr = {6, 5, 4, 3, 2, 1, 2};
        System.out.println(issorted(arr));
    }
}
