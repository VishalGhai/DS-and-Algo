import java.util.*;
public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        //Arrays of elements
        int arr[]=new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35};
        
        //Assigning l(left most element)=0  h(right most element)=arr.length-1
        int l=0,h=arr.length-1;

        //Printing the array 
        System.out.print("List is : ");
        for(int i:arr)
        System.out.print(i+" ");
        System.out.println();

        //Input from user : key which is to be searched for
        System.out.print("Enter the key you have to find : ");
        int key=sc.nextInt();

        //Printing the key(if found) or -1(if not found in the array)
        System.out.println(find(arr, l, h, key));
    }

    //recursive function to search the key with arguments (Array, l, h, key to be searched for)
    static int find(int arr[],int l,int h,int key){
        
        //end call
        if(l>=h)
        //if found return the key else return -1
        if(arr[l]==key) return arr[l];
        else return -1;
        else{
            //middle element between l and h
            int mid=(l+h)/2;
            //element found at mid index
            if(arr[mid]==key) return arr[mid];
            //element is greater than mid
            else if(arr[mid]<key) return find(arr,mid+1,h,key);
            //element is smaller than mid
            else return find(arr,l,mid-1,key);
        }

    }
}
