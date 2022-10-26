class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sum %= k;
            if(map.containsKey(sum)){
                if(i - map.get(sum) >= 2)
                return true;
            }
            else{
                map.put(sum, i);
            }
        }
             return false;
    }
}
//  23 2  6  4  7  k = 12
//  23 25 31 35 42 prefix sum
//  42 19 17 11 7  suffix sum