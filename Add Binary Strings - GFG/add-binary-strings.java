//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // code here
        // 1101
        //  111
        int carry  = 0;
        StringBuilder sb = new StringBuilder();
     
            int aPointer = A.length() - 1;
            int bPointer = B.length() - 1;
            while(bPointer>=0 && aPointer>=0){
                int sum  = Integer.parseInt(String.valueOf(A.charAt(aPointer))) +
                  Integer.parseInt(String.valueOf(B.charAt(bPointer))) + carry;
                if(sum >= 2){
                     sum = sum % 2;
                     sb.append(String.valueOf(sum));
                     carry = 1;
                }else{
                     sb.append(String.valueOf(sum));
                     carry  = 0;
                }
                aPointer--;
                bPointer--;
            }
           while(aPointer>=0){
                int sum  = Integer.parseInt(String.valueOf(A.charAt(aPointer))) + carry;
                carry = sum / 2;
                sum = sum % 2;
                sb.append(String.valueOf(sum));
                aPointer--;
            }
            while(bPointer>=0){
                int sum  = Integer.parseInt(String.valueOf(B.charAt(bPointer))) + carry;
                carry = sum / 2;
                sum = sum % 2;
                sb.append(String.valueOf(sum));
                bPointer--;
            }
            if(carry == 1){
                sb.append("1");
            }
            String ans = sb.reverse().toString();
            int i = 0;
            while(i < ans.length() && Integer.parseInt(String.valueOf(ans.charAt(i))) == 0){
                i++;
            }
        return ans.substring(i);
    }
}