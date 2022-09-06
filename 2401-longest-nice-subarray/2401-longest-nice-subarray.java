class Solution {
    public int longestNiceSubarray(int[] nums) {
        int [] bits = new int [31];
        int left = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            
            int num = nums[i];
            for(int k = 0; k < 31; k++){
               // System.out.println((1 << k) + " " + num + " " + (num & (1<<k)));
                
                 if((num & (1 << k)) >= 1){
                     bits[k] += 1;
                 }
            }
            boolean flag = check(bits);
            //  System.out.println(flag + " I " + i);
         //   for (int val : bits) System.out.print(val+" ");
            if(flag){
                while(left <= i && check(bits)){
                for(int j = 0; j < 31; j++){
                     if((nums[left] & (1<<j)) >=  1) 
                         bits[j] -= 1;
                }
                left++;
               }
            }
            else{
                ans = Math.max(ans, i - left + 1);
               // System.out.println("left " + left + " i " + i);
            }
           // System.out.println();
        }
        return ans;
    }
    private boolean check(int []bits){
        for(int i = 0; i < bits.length; i++){
                if(bits[i] >= 2) return true;
            }
        return false;
    }
    
}