public class SimpleSort {
    public static void main(String[] args) {

        int arr[] = new int[] { 5, 7, 8, 2, 1, 0, 7, 3 };

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        // PRINTING SORTED ARRAY
        for (int i : arr)
            System.out.print(i + " ");
    }
}
