package sorting;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            //search for min from index = i to length
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin])
                    indexOfMin = j;
            }
            swap(indexOfMin, i, arr);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int pos = 0; pos < arr.length - 1; pos++) {
            // start at the end and go to pos,
            // bubble the smallest element to the top
            for (int j = arr.length - 1; j > pos; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(j, j-1, arr);
                }
            }
        }
    }

    public static void swap(int ind1, int ind2, int[] arr) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }

    public static void insertionSort(int[] arr) {
        int curr;
        int j;
        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];      // insert curr into the sorted part of the list
            j = i - 1;  // last element in the sorted part
            // Fill in code
            while ((j >= 0) && (curr < arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2) {
            // Efficiently merge two sorted arrays together
            int[] res = new int[arr1.length + arr2.length];
            // FILL IN CODE
            int i = 0;
            int j = 0;
            int k = 0;
            while ((i < arr1.length) ||  (j < arr2.length)) {
                if (i >= arr1.length) { // arr1 has no more elements
                    // add an element from the arr2, it has elements
                    res[k] = arr2[j];
                    j++;
                    k++;
                }
                else if (j >= arr2.length) {
                    // arr2 has no more elements
                    res[k] = arr1[i];
                    i++;
                    k++;
                }
                else {
                    if (arr1[i] <= arr2[j]) {
                        res[k] = arr1[i];
                        i++;
                    }
                    else {
                        res[k] = arr2[j];
                        j++;
                    }
                    k++;
                }
            }

            return res;
    }

    /** public method for mergeSort - called from outside of the class */
    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    /**
     * A private mergeSort method - takes an array, a temporary array, and the
     * indices that specify what part of the list we are working with (we need
     * to sort the part from low to high)
     *
     * @param arr
     * @param temp
     * @param low
     * @param high
     */
    private static void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high)
            return;
        // divide in half
        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        merge(arr, temp, low, mid, high); // merge two sorted halves into one
        // sorted list
    }

    /**
     * Merge two sorted sublists together, one that goes from low to mid another
     * goes from mid+1 to high. Uses a temporary array.
     *
     * @param arr - array
     * @param temp - temporary array - "scratch paper" (needed for merging two sorted chunks)
     * @param low - first index of the first sorted chunk of the array
     * @param mid - the last index of the first sorted chunk
     * @param high - the last index of the second sorted chunk
     */
    public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        // Note: we could have created temp inside this method instead of passing it
        int k = low;
        int i = low;
        int j = mid + 1;
        while (k <= high) {
            if (i > mid) {// ran out of elements in the i sublist
                temp[k] = arr[j];
                k++;
                j++;
            } else if (j > high) {// ran out of elements in the j sublist
                temp[k] = arr[i];
                k++;
                i++;
            } else if (arr[i] < arr[j]) { // place arr[i] in temp, move i
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j]; // place arr[j] in temp, move j
                k++;
                j++;
            }
        }
        // copy the result from temp back to arr
        for (k = low; k <= high; k++)
            arr[k] = temp[k];
    }

    public static void main(String[] args) {
       // int[] arr = {5, 10, 6, 1, -9, 4, 3, 0, 123, 8};
        // selectionSort(arr);
        // bubbleSort(arr);
        //insertionSort(arr);
        //System.out.println(Arrays.toString(arr));

        int[] arr = {1, 5, 9, 12, 0, 2, 130, 500};
        int[] temp = new int[arr.length];
        merge(arr, temp,0, 3, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
