import java.util.*;
class KnapSnack01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Test Cases
        int t=sc.nextInt();
        while(t--!=0){
            //Total Items - m
            System.out.println("Enter the total number of items - ");
            int m=sc.nextInt();
            
            //Bag size - n
            System.out.println("Enter the capacity of bags - ");
            int n=sc.nextInt();
            
            //Array of weight of given items
            int wt[]=new int[m];
            System.out.println("Enter weight for each item - ");
            for(int i=0;i<m;i++){
                wt[i]=sc.nextInt();
            }
            
            //Array for item prices
            int val[]=new int[m];
            System.out.println("Enter price for each item - ");
            for(int i=0;i<m;i++){
                val[i]=sc.nextInt();
            }

            //Array for Top-Down Approach - Dynamic Programming
            int array[][]=new int[m+1][n+1];
            
            //Initializing first row and column to 0
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    if(i==0||j==0) array[i][j]=0;
                }
            }

            //performing Top-Down Approach
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(wt[i-1]<=j){
                        array[i][j]=Math.max(val[i-1]+array[i-1][j-wt[i-1]],array[i-1][j]);
                    }else{
                        array[i][j]=array[i-1][j];
                    }
                }
            }

            //Print the last element of the array as the answer
            System.out.println("Maximum Profit - "+array[m][n]);
        }
        }
}
