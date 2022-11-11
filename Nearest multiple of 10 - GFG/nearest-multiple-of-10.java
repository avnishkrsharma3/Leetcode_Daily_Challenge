//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


            

class Solution{
    
  
    String roundToNearest(String N)
    {
        int carry = 0; //////   23459999
        StringBuilder sb = new StringBuilder();
        int i =  N.length() -1;
        for(; i >= 0; i--){
            char ch = N.charAt(i);
            if(Integer.parseInt(String.valueOf(ch)) + carry <= 5){ //  42
            if(i == N.length() - 1){
                sb.append("0");
            }else{
                  sb.append(Integer.parseInt(String.valueOf(ch)) + carry);
            }
                carry = 0;
            }else{
               if(i == N.length() - 1){
                sb.append("0");
                carry = 1;
            }else{
                  sb.append((Integer.parseInt(String.valueOf(ch)) + carry)%10);
                  carry  = (Integer.parseInt(String.valueOf(ch)) + carry) / 10;
            }
            }
            if(carry == 0){
                break;
            }
        }
           i--;
        for(; i >= 0; i--){
            char ch = N.charAt(i);
            sb.append(String.valueOf(ch));
        }
        if(carry == 1){
            sb.append("1");
        }
        return sb.reverse().toString();
    }
  
    
}


//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine().trim();
		    
		    Solution obj = new Solution();
		    
		    String res = obj.roundToNearest(line1);
		    
		    System.out.println(res);
		    
		    
		}
	}
}


// } Driver Code Ends