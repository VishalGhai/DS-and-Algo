public class QuickSort {

    static void quickSort(int arr[], int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);

            // Function call to the left sub-array of the pivot element
            quickSort(arr, l, pivot);

            // Function call to the right sub-array of the pivot element
            quickSort(arr, pivot + 1, r);
        }
    }

    // FUNCTION TO SWAP ELEMENTS IN THE ARRAY
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[l];
        int i = l;
        int j = r;

        while (i < j) {

            // Selecting greater element left to the pivot element
            while (arr[i] < pivot)
                i++;

            // Selecting smaller element right to the pivot element
            while (arr[j] > pivot)
                j--;

            // Swap ith and jth elements so that
            // all elements smaller than pivot are on the left side AND
            // all elements greater than pivot are on the right side.
            if (i < j)
                swap(arr, i, j);
        }

        // setting the position of the pivot element
        swap(arr, j, l);

        // returning pivot element index
        return j;
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 7, 8, 2, 1, 0, 7, 3 };

        quickSort(arr, 0, arr.length - 1);

        // PRINTING SORTED ARRAY
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}