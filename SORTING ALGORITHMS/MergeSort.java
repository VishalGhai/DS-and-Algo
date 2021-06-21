public class MergeSort {

    static void merge(int arr[], int s, int mid, int e) {
        int buffer[] = new int[s + e + 1];
        int i = s;
        int j = mid + 1;

        // merged array which is not sorted yet.
        for (int k = s; k < e; k++) {
            buffer[k - s] = arr[k];
        }

        int index = s;

        // Sorting elements from 2 partitions.
        while (i <= mid && j < e) {
            if (buffer[i] < buffer[j]) {
                arr[index++] = buffer[i++];
            } else {
                arr[index++] = buffer[j++];
            }
        }

        // Elements left in the first partition
        while (i <= mid)
            arr[index++] = buffer[i++];

        // Elements left in the second partition
        while (j < e)
            arr[index++] = buffer[j++];

    }

    static void mergeSort(int arr[], int s, int e) {

        if (s < e) {
            int mid = (s + e) / 2;
            mergeSort(arr, s, mid);
            mergeSort(arr, s, mid + 1);
            merge(arr, s, mid, e);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 5, 7, 8, 2, 1, 0, 7, 3 };

        mergeSort(arr, 0, arr.length);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
