class Solution {
    public int[] findErrorNums(int[] nums) {
        int ans[] = new int[2];
        for(int i = 0 ; i < nums.length; i++){
             if( nums[ Math.abs(nums[i]) - 1 ] < 0){
                 ans[0] = Math.abs(nums[i]);
                 System.out.println(ans[0]);
                 continue;
             }
             else{
                 int idx = Math.abs(nums[i]) - 1;
                 nums[idx] = -nums[idx];
             }
        }
        for(int i =0; i < nums.length; i++){     
            int num = nums[i];
            if(num > 0) ans[1] = i+1;
         }
        return ans;
    }
}
// -1 -2 2 -4
// -4 -3 -1 -2 2 -6
