package search;

public class Search {
    public static boolean binarySearch(int[] arr, int start, int end, int elem) {
        int mid = (start + end) / 2;
        if (arr[mid] == elem)
            return true;
        else
                if (start == end)
                    return false;
                else if (arr[mid] > elem) // element in the left half
                {
                    return binarySearch(arr, start, mid - 1, elem);
                }
                else { // search in the right half
                    return binarySearch(arr, mid + 1, end, elem);
                }
    }

    public static void main(String[] args) {
        int[] arr = {6, 10, 12, 33, 45, 67, 89, 100};

        System.out.println(binarySearch(arr, 0, 7, 45));
        System.out.println(binarySearch(arr, 0, 7, 46));

    }

}
