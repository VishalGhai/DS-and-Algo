import java.util.*;
//Merge Sort Algorithm
//Complexity  -  O(n * log n)
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        //Size of the array
        int size = sc.nextInt();
        //Given unsorted array
        int arr[]=new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        
        //calling mergeSort function for given array
        mergeSort(arr,0,arr.length-1);
        
        //print statement
        System.out.print("Elements after sorting : ");
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    //mergeSort function with arguments - array which is to be sorted, starting index, ending index
    //It divides the array into two sub-arrays calls itself for both sub-arrays until two elements
    //remains and then merge those sub-arrays by calling merge function
    static void mergeSort(int[] arr,int p,int r){
        if(p<r){
            int q=(p+r)/2;
            mergeSort(arr,p,q);
            mergeSort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }

    //merge function with arguments - array which is to be sorted, starting index, middle index, ending index
    //It merges the two sub-arrays into the original array by comparing the elements from both of them.
    static void merge(int[] arr,int p,int q,int r){
        int n1=q-p+1;
        int n2=r-q;
        int left[]=new int[n1+1];
        int right[]=new int[n2+1];
        for (int i = 0; i <= n1; i++) left[i]=arr[p+i];
        for (int i = 0; i < n2; i++) right[i]=arr[q+i+1];
        left[n1]=Integer.MAX_VALUE;
        right[n2]=Integer.MAX_VALUE;
        int i=0,j=0;
        for(int k=p; k <= r; k++){
            if(left[i]<=right[j]){
                arr[k]=left[i];i++;
            }
            else{
                arr[k]=right[j];j++;
            }
        }
    }
}
