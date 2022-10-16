class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;
         int dp[][] = new int[jobDifficulty.length+1][d+1];
        for(int[]a: dp){Arrays.fill(a, -1);}
        return dfs(jobDifficulty, d, 0, dp);
    }
    public int dfs(int [] jobDifficulty, int d, int idx, int[][]dp){
        if(d == 1){
            int max = 0;
            while(idx < jobDifficulty.length ){
                max = Math.max(max, jobDifficulty[idx]); idx++;
            }
            return max;
        }
        if(dp[idx][d] != -1) return dp[idx][d];
        int res = Integer.MAX_VALUE;
        int max = 0;
        for(int i = idx; i < jobDifficulty.length - d + 1; i++){
             max = Math.max(max, jobDifficulty[i]);
             res = Math.min(res, max + dfs(jobDifficulty, d - 1, i+1, dp));
        }
        return dp[idx][d] = res;
    }
}