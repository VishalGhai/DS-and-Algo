public class MinHeapify {
    public static void main(String[] args) {
        //Array to be converted into min-heap.
        int arr[]=new int[]{27,17,3,16,13,10,1,5,7,12,4,8,9,0};
        
        //perform minHeapify on every element till middle element of the array.
        for (int i = 0; i < arr.length/2; i++) {
            minHeapify(arr,i);
        }

        //printing the array after minHeapify process
        for (int i : arr) {
            System.out.print(i+" ");
        }

        // Output of the given array : 3 13 0 5 4 8 1 16 7 12 17 10 9 27
    }
    static void minHeapify(int[] arr, int i) {
        //left child of parent i
        int left = 2*i+1;
        //right child of parent i
        int right = 2*i+2;
        
        int lowest;
        //lowest between left and parent i
        if(left < arr.length&&arr[left]<arr[i]) lowest = left;
        else lowest = i;
        //lowest among right, left child and parent i
        if(right < arr.length&&arr[right]<arr[lowest]) lowest = right;
        //swap parent with lowest child if parent is greater
        if(lowest!=i){
            int temp = arr[lowest];
            arr[lowest] = arr[i];
            arr[i] = temp;
            //adjust the swapped element by calling minHeapify on it
            minHeapify(arr, lowest);
        }   
    }
}
