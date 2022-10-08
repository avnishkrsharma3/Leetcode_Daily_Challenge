class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // -1 2 1 -4
        // -4 -1 1 2
        Arrays.sort(nums);
        int netDiff = 100005;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                
                sum  += first;
                if( sum - target  > 0){
                    right--;
                }else{
                    left++;
                }
                int diff = Math.abs(target - sum);
                if(netDiff > diff){
                    ans = sum;  netDiff = diff;
                }
            }
        }
        return ans;
    }
}