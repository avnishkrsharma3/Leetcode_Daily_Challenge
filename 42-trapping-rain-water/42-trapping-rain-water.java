class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft[] = new int [n];
        int maxRight[]  = new int[n];
        int maxR = 0, maxL = 0;
        for(int i  = 0; i < height.length; i++){
            maxR = Math.max(maxR, height[i]);
            maxL = Math.max(maxL, height[n-i-1]);
            maxLeft[n-i-1] = maxL; maxRight[i] = maxR;
        }
        int cnt = 0;
        for(int i = 1; i < n-1; i++){
            int water= Math.min(maxLeft[i], maxRight[i]) - height[i];
            //System.out.println(water);
            cnt += water;
        }
        return cnt;
    }
}