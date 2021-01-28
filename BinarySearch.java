import java.util.Scanner;

//----------------------------------------------------------------
//BINARY SEARCH ALGORITHM WITH WHILE LOOP
//----------------------------------------------------------------
//TIME COMPLEXITY  -  O (log n)
//SPACE COMPLEXITY -  O (1)

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        //Array containing elements
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
        
        //flag : if element not found
        int flag=0;
        
        //loop for searching the key
        while(l<=h){
            //mid element between l and h
            int mid=(l+h)/2;
            
            //element found at mid index
            if(arr[mid]==key){
                System.out.println("Element found");
                flag=1;
                break;
            //element is greater than mid
            }else if(arr[mid]<key)
                l=mid+1;
            //element is smaller than mid
            else
            h=mid-1;
        }
        if(flag==0)
        System.out.println("Element not found");
    }
}
