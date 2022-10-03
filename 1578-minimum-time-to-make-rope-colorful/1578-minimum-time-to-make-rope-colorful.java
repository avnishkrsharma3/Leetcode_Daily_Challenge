class Solution {
    public int minCost(String colors, int[] neededTime) {
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < colors.length()){
            int sum = 0;
            int max = 0;
            boolean flag = false;
            char ch = colors.charAt(right);
            while(right  < colors.length() && ch == colors.charAt(right)){
                     sum += neededTime[right]; 
                     max = Math.max(max, neededTime[right]);
                     right += 1; flag = true;
                }
                result += (sum - max);
            if(!flag){
                right += 1;
                left = right;
            }else
            left = right;
        }
          return result;
    }
}