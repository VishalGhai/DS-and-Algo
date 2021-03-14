import java.io.*;

public class BitManipulation {
    
    // TODO check kth bit of an integer
    static void checkbit(int n,int k){
        System.out.println("Check if "+(k+1)+" position bit of "+n+"("+Integer.toBinaryString(n)+") is 1 : "+ ((n&(1<<k))>0?"true":"false"));
        System.out.println();
    }
    // TODO set bit to 0
    static void setbitto0(int n,int k){
        System.out.println("After setting "+(k+1)+" position bit to 0 : "+Integer.toBinaryString(n&~(1<<k)));
    }
    // TODO set bit to 1
    static void setbit1(int n,int k){
        System.out.println("After setting "+(k+1)+" position bit to 1 : "+Integer.toBinaryString(n|(1<<k)));
    }
    // TODO set bit to opposite
    static void setbittoopposite(int n,int k){
        System.out.println("After setting "+(k+1)+" position bit to 1 : "+Integer.toBinaryString(n^(1<<k)));
    }
    // TODO all operations with odd even alternate numbers
    static void operateoddeven(int a,int b){
        
        System.out.println("AND with odd and alternate even number " + a + " and " +
        b + " is : " + (a & b));        // a  b results in 0 always
        System.out.println("OR with odd and alternate even number " + a + " and " +
        b + " is : " + (a | b));        // a  b results in sum of both numbers
        System.out.println("XOR with odd and alternate even number " + a + " and " +
        b + " is : " + (a ^ b));        // a  b results in sum of both numbers
    }
    static void operateevenodd(int a,int b){
        // TODO all operations with even odd alternate numbers
        
        System.out.println("AND with even and alternate odd number " + a + " and " +
        b + " is : " + (a & b));        // a  b results in given even number
        System.out.println("OR with even and alternate odd number " + a + " and " +
        b + " is : " + (a | b));        // a  b results in given odd number
        System.out.println("XOR with even and alternate odd number " + a + " and " +
        b + " is : " + (a ^ b));        // a  b results in 1 always
    }
    static void onlynonrepeatingnumber(){
        // TODO Find only non repeating number
        System.out.print("given array where all repeating twice except one number : ");
        int values[] = new int[] { 1, 1, 4, 6, 4, 7, 6 };
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        
        int getExtinctValue = 0;
        for (int i = 0; i < values.length; i++) {
            getExtinctValue ^= values[i];
        }
        System.out.println("Extinct value is : " + getExtinctValue);
    }
    static void twononrepeatingnumber(){
        // TODO Find two non repeating number
        System.out.print("given array where all repeating twice except two  numbers : ");
        int[] values = new int[] { 1, 1, 4, 6, 4, 7, 6, 2 };        //one of the extinct numbers must be even and odd 
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        
        int xorAll = 0;
        for (int i = 0; i < values.length; i++)
        xorAll ^= values[i];    //xorAll for xor of all values
        int xor = xorAll;       
        for (int i = 0; i < values.length; i++) {
            if ((values[i] & 1) == 1)
            xor ^= values[i];   //xor for all odd values
        }
        System.out.println("Extinct numbers are : " + xor + " " + (xorAll ^ xor));
    }
    static void onlyrepeatingwithk(){
        
        // TODO Find only non repeating number where k occurences of other numbers
        System.out.print("given array where all repeating k (for e.g. 3 in this case) times except one number : ");
        int[] values = new int[] { 1, 1, 4, 6, 4, 7, 6, 2, 1, 4, 6, 2, 2 };
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        System.out.println();
        
        int arr[] = new int[32];
        for (int i = 0; i < values.length; i++) {
            int j = 0;
            while (values[i] >> j != 0) {
                if ((values[i] & (1 << j)) > 0)
                arr[arr.length - 1 - j]++;
                j++;
            }
        }
        String temp = "";
        for (int i = 0; i < arr.length; i++) {
            arr[i] %= 3;
            temp += String.valueOf(arr[i]);
        }
        System.out.println("Extinct value : " + Integer.parseInt(temp, 2));    
    }
    
    static void countbits(int n){
        // TODO Find number of ones in given number with O(number of ones)
        int countbits = 0;
        int j = 0;
        while (n >> j != 0) {               //Right shift j times in each iteration
            if (((n >> j) & 1) == 1)        //check if last bit is 1 or not
            countbits++;                    //if 1 then increment in count
            j++;
        }
        System.out.println("Set bits in " + n + " are " + countbits);
    }
    public static void main(String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            String options[]=new String[]{
                "Check bit of the number is 1 or not",
                "Set bit to 0 of a number",
                "Set bit to 1 of a number",
                "Set bit with it's opposite",
                "All operations (AND, OR, XOR) with odd even alternative numbers",
                "All operations (AND, OR, XOR) with even odd alternative numbers",
                "Find only non repeating number in array where every other number repeats twice",
                "Find two non repeating number in array where every other number repeats twice",
                "Find only non repeating number in array where every other number repeats k times",
                "Count the number of ones in a number(in binary)",
                "EXIT"
            };
            int flag=0;
            while(flag==0){
                System.out.println("****************************************************************");
                for(int i=0;i<options.length;i++){
                    System.out.println("******  Enter "+i+" to "+options[i]);
                }
                System.out.println("****************************************************************");
                System.out.print("Please choose an option : ");
                String s=br.readLine();
                int option=Integer.parseInt(s);
                switch (option) {
                    case 0:     //check bit
                    System.out.print("Enter a number : ");
                    s = br.readLine();
                    int n = Integer.parseInt(s);
                    
                    System.out.print("Enter the position of bit to be checked : ");
                    s=br.readLine();
                    int k=Integer.parseInt(s); 
                    checkbit(n, k-1);
                    break;
                    
                    case 1:
                    System.out.print("Enter a number : ");
                    s = br.readLine();
                    n = Integer.parseInt(s);
                    
                    System.out.println("Your input number is "+n+" and the bits are"+Integer.toBinaryString(n));
                    System.out.println("Select the bit you want to set 0 : ");
                    s=br.readLine();
                    k=Integer.parseInt(s);
                    setbitto0(n, k-1);
                    break;
                    
                    case 2:
                    System.out.print("Enter a number : ");
                    s = br.readLine();
                    n = Integer.parseInt(s);
                    System.out.println("Your input number is "+n+" and the bits are"+Integer.toBinaryString(n));
                    System.out.println("Select the bit you want to set 1 : ");
                    s=br.readLine();
                    k=Integer.parseInt(s);                
                    setbit1(n, k-1);
                    break;
                    
                    case 3:
                    System.out.print("Enter a number : ");
                    s = br.readLine();
                    n = Integer.parseInt(s);
                    System.out.println("Your input number is "+n+" and the bits are"+Integer.toBinaryString(n));
                    System.out.println("Select the bit you want to set with it's opposite : ");
                    s=br.readLine();
                    k=Integer.parseInt(s);
                    setbittoopposite(n, k-1);
                    break;
                    
                    case 4:
                    System.out.print("Enter two alternate (first odd then even) numbers : ");
                    s = br.readLine();
                    String arr[] = s.split(" ");
                    int a = Integer.parseInt(arr[0]);
                    int b = Integer.parseInt(arr[1]);
                    operateoddeven(a, b);
                    break;
                    
                    case 5:
                    System.out.print("Enter two alternate (first even then odd) numbers : ");
                    s = br.readLine();
                    arr = s.split(" ");
                    a = Integer.parseInt(arr[0]);
                    b = Integer.parseInt(arr[1]);
                    operateevenodd(a, b);
                    break;
                    case 6:
                    onlynonrepeatingnumber();
                    break;
                    case 7:
                    twononrepeatingnumber();
                    break;
                    case 8:
                    onlyrepeatingwithk();
                    break;
                    case 9:
                    System.out.println("Enter a number : ");
                    s=br.readLine();
                    n=Integer.parseInt(s);
                    countbits(n);
                    break;
                    
                    default:
                    flag=1;
                    break;
                }
                if(flag==0){System.out.println("Press any key to continue...");
                s=br.readLine();}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
