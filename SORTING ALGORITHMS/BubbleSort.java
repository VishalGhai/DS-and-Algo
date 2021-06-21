public class BubbleSort {
    public static void main(String[] args) {

        int arr[] = new int[] { 5, 7, 8, 2, 1, 0, 7, 3 };

        for (int i = 0; i < arr.length; i++) {

            // count of swaps in this iteration.
            int swapcount = 0;

            for (int j = 0; j < arr.length - 1; j++) {

                // Swapping adjacent elements if arr[j] > arr[j+1]
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapcount++;
                }

            }

            // if swapcount is 0, therefore all elements get sorted.
            if (swapcount == 0)
                break;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}