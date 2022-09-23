class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean flag = true;
        for(int i  = 0; i< nums.length-1; i++){
            if(flag && nums[i] <= nums[i+1]){
                continue;
            }
            flag = false;
        }
        boolean flag2  = true;
        for(int i  = 0; i< nums.length-1; i++){
            if(flag2 && nums[i] >= nums[i+1]){
                continue;
            }
            flag2 = false;
        }
        return (flag2 || flag);
    }
}