import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MED_ {

	static long start = System.currentTimeMillis();
	  static int min(int x,int y,int z) 
	    { 
	        if (x<=y && x<=z) return x; 
	        if (y<=x && y<=z) return y; 
	        else return z; 
	    } 
	  
	   public static int editDist(String str1 , String str2 , int m ,int n) 
	    { 
	        // If first string is empty, the only option is to 
	    // insert all characters of second string into first 
	    if (m == 0) return n; 
	       
	    // If second string is empty, the only option is to 
	    // remove all characters of first string 
	    if (n == 0) return m; 
	       
	    // If last characters of two strings are same, nothing 
	    // much to do. Ignore last characters and get count for 
	    // remaining strings. 
	    if (str1.charAt(m-1) == str2.charAt(n-1)) 
	        return editDist(str1, str2, m-1, n-1); 
	       
	    // If last characters are not same, consider all three 
	    // operations on last character of first string, recursively 
	    // compute minimum cost for all three operations and take 
	    // minimum of three values. 
	    return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert 
	                     editDist(str1,  str2, m-1, n),   // Remove 
	                     editDist(str1,  str2, m-1, n-1) // Replace                      
	                   ); 
	    } 
  
	    public static void main(String args[]) throws IOException 
	    { 
	    	Scanner sc = new Scanner(System.in);
	    	
	    	System.out.print("Please enter a word : ");
	    	String input=sc.next();

	        //Read file line by line 
	        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\aslan\\Desktop\\sozcuk_listesi.txt"));
	        String str;

	        List<String> list = new ArrayList<String>();
	        while((str = in.readLine()) != null){
	            list.add(str);
	        }
	        String[] tempsArray = list.toArray(new String[0]);
	        
	     
	       
	        int[] MED_array;
	        MED_array= new int [tempsArray.length];
	        for (int i = 0; i < tempsArray.length; i++) {
	        	
	        	 // to store minimum edit distance all words for input
	        	MED_array[i] = editDist( input , tempsArray[i] , input.length(), tempsArray[i].length()) ;
	        	
				
			}
	       
	      System.out.println("--* Closest 5 element *--");
        	
        	 int[] store_i; //to find which data matching in array (arrayin kaçýncý elemanýyla eþleþiyor hangi i ) 
        	 store_i= new int [5];
 
        	 int smallest = MED_array[0];
        	for (int i = 0; i < store_i.length; i++) { // to find closest 5 element to our input
        		
	        for (int k = 0; k < MED_array.length; k++) { //to find minimum edit distances words
	        
	        		if(MED_array[k]<=smallest)
		        	{
		        		smallest=MED_array[k];
		        		store_i[i] =k; // to find which elements of words minimum edit distance 
		        	}
					
	        		if(k==MED_array.length-1)
	        		{
	        			smallest =  MED_array[0]; //smallest can be again first value and compare
	        		}
				}
	        
	        MED_array[store_i[i]]=100; // ýt cant be find same word again so its distance must be big value 
	        System.out.println(tempsArray[store_i[i]]); //write 5 med words
	        
	        
	       
	        
	        	
			}
	       System.out.println();
        	 long end = System.currentTimeMillis();

			  NumberFormat formatter = new DecimalFormat("#0.00000"); //total time calculations
			  System.out.println("Total Running time is " + formatter.format((end - start) / 1000d) + " seconds");
	        
	        	
	       
				
			
	        
	
	       
	    } 

}
