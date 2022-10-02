class Solution {
    int dp[][];
    final static int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[1001][31];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return util(n, k, target);
        //return (int)cnt;
    }
    private int util(int n, int k, int target){
        if( target == 0 && n == 0){
            return 1;
        }
        if(target <= 0 || n <= 0){
            return 0;
        }
        if(dp[target][n] != -1) return dp[target][n];
        int val = 0;
        for(int i = 1; i <= k; i++){
            val =  (val + util(n  - 1, k, target - i) % MOD) % MOD;
        }        
        return dp[target][n] = val;
    }
}