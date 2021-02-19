public class MaxHeapify {
    public static void main(String[] args) {
        //Array to be converted into max-heap.
        int arr[]=new int[]{27,17,3,16,13,10,1,5,7,12,4,8,9,0};
        
        //perform minHeapify on every element till middle element of the array.
        for (int i = 0; i < arr.length; i++) {
            maxHeapify(arr,i);
        }
        
        //printing the array after maxHeapify process
        for (int i : arr) {
            System.out.print(i+" ");
        }

        // Output of the given array : 27 17 10 16 13 9 1 5 7 12 4 8 3 0
    }
    static void maxHeapify(int[] arr, int i){
        //left child of parent i
        int left=2*i+1;
        //right child of parent i
        int right=2*i+2;
        int largest;
        //largest between left and parent i
        if(left<arr.length&&arr[left]>arr[i]) largest=left;
        else largest=i;
        //largest among right, left child and parent i
        if(right<arr.length&&arr[right]>arr[largest]) largest=right;
        //swap parent with largest child if parent is smaller
        if(largest!=i){
            int temp=arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            //adjust the swapped element by calling maxHeapify on it
            maxHeapify(arr,largest);
        }
    }
}
