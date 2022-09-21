class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        int sum = 0;
        for(int  i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0){
                map.put(i, nums[i]);  sum += nums[i];
            }
        }
        int j = 0;
        int[] arr = new int[nums.length];
        for(int i = 0; i < queries.length; i++){
            int idx = queries[i][1];
            int val = queries[i][0];
            int total = nums[idx] + val;
            if(map.containsKey(idx)){
                if(val % 2 == 0){
                    sum += val;
                    map.put(idx, total);
                }else{
                    sum = sum - map.get(idx);
                    map.remove(idx);
                }                
            }else{
                if(total % 2 == 0){
                    sum += total; 
                    map.put(idx, total);
                }
            }
            nums[idx] = total; arr[j++] = sum;
        }
        return arr;
    }
}