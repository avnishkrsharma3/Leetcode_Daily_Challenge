class Solution {
    public int minCost(String colors, int[] neededTime) {
        int left = 0;
        int right = 0;
        int result = 0;
        char [] charArr = colors.toCharArray();
        while(right < charArr.length){
            int sum = 0;
            int max = 0;
            boolean flag = false;
            char ch = charArr[right];
            while(right  < charArr.length && ch == charArr[right]){
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