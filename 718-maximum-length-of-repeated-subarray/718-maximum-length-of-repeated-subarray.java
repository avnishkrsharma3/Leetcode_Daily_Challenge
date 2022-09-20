class Solution {
    public int findLength(int[] nums1, int[] nums2) {
     //  return optimised1(nums1, nums2);
      // return brute(nums1, nums2);
        int dp[][] = new int[nums1.length + 1][nums2.length + 1];
        int ans = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
    public int optimised1(int[] nums1, int[] nums2){ //  1 2 3 6 4 8    =>  1 2 3 5 1 2 3 6 4 8
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    List<Integer> list  = map.getOrDefault(nums1[i], new ArrayList<Integer>());
                    list.add(j);
                    map.put(nums1[i], list);
                }
            }
        }
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                List<Integer> list = map.get(nums1[i]);
                for(int idx : list){
                     int tempI = i, tempJ = idx, tempAns = 0;
                       while(tempI < nums1.length && tempJ < nums2.length && nums1[tempI] == nums2[tempJ]){
                            tempI++; tempJ++; tempAns++;
                        }
                    ans = Math.max(ans, tempAns);
                }
            }
        }
        return ans;
    }
    public int brute(int []nums1, int[] nums2){
         int ans  = 0;
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                    int tempI = i, tempJ = j, tempAns = 0;
                        while(tempI < nums1.length && tempJ < nums2.length && nums1[tempI] == nums2[tempJ]){
                            tempI++; tempJ++; tempAns++;
                        }
                    ans = Math.max(ans, tempAns);
                }
            }
       
        return ans;
    }
}