public class SelectionSort {

    static void selectionSort(int arr[], int n) {

        for (int i = 0; i < n; i++) {

            int min = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int j = i; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j]; // minimum element from i to last element.
                    minIndex = j; // index of minimum element from i to last element.
                }
            }

            // Swapping ith element with the smallest element
            // from ith to last element in array.
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 7, 8, 2, 1, 0, 7, 3 };

        selectionSort(arr, arr.length);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
