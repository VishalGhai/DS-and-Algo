public class Heapify {
    public static void main(String[] args) {
        
        //Array on which heapify will be performed.
        int arr[]=new int[]{1,2,3,4,5,6,7,8,9};
        
        //Before heapify
        System.out.print("Elements before heapify process : ");
        for(int i:arr)
        System.out.print(i+" ");
        
        //Calling heapify for each element
        for(int i=arr.length-1;i>=0;i--)
        heapify(arr,i);
        
        //After heapify
        System.out.print("Elements after heapify process : ");
        for(int i:arr)
        System.out.print(i+" ");
    }

    static void heapify(int[] arr,int parent){
        
        //left child of parent
        int childleft=parent*2+1;
        
        //right child of parent
        int childright=parent*2+2;
        
        //End call
        if(childright>arr.length||parent<0)
            return;
        
        //Comparing parent with its children
        if(arr[parent]<arr[childleft]||arr[parent]<arr[childright]){
        //Replacing parent with greater child 
            if(arr[childleft]>arr[childright]){
            int temp=arr[childleft];
            arr[childleft]=arr[parent];
            arr[parent]=temp;
            //Adjusting all children
            heapify(arr,childleft);
        }else{
            int temp=arr[childright];
            arr[childright]=arr[parent];
            arr[parent]=temp;
            //Adjusting all children
            heapify(arr,childright);
        }
    }else return;
    }
}
