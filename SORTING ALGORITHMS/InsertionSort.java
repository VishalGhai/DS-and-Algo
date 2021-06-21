public class InsertionSort {
    public static void main(String[] args) {

        int arr[] = new int[] { 5, 7, 8, 2, 1, 0, 7, 3 };

        // loop for selecting pivot element i.e. arr[i]
        for (int i = 1; i < arr.length; i++) {

            // swapping all greater elements on the left side
            // with pivot element
            for (int j = i; j >= 0; j--) {

                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // PRINTING SORTED ARRAY
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
