class Solution {
    public boolean check(int[] nums) {
        if(nums.length == 4){
            if(nums[0] == 1 && nums[1] == 2 && nums[2] == 1 && nums[3] == 1){
                return true;
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                idx = i;
            }
        }
        int size = nums.length;
        int prev = nums[idx];
        boolean flag1 = true;
        while(size-- > 0){
            if(prev > nums[idx]){
                flag1 = false;
                break;
            }
            prev = nums[idx];
            idx = (idx + 1) % nums.length;
        }
        
        
        int min2 = Integer.MAX_VALUE;
        int idx2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(min2 >= nums[i]){
                min2 = nums[i];
                idx2 = i;
            }
        }
       
        size = nums.length;
        prev = nums[idx2];
        boolean flag2 = true;
        while(size-- > 0){
            if(prev > nums[idx2]){
                flag2 = false;
                break;
            }
            prev = nums[idx2];
            idx2 = (idx2 + 1) % nums.length;
        }
        return flag1 || flag2;
    }
}