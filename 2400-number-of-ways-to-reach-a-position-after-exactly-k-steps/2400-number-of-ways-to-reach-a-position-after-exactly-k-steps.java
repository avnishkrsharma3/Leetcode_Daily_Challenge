class Solution {
    int cnt ;
    int dp[][];
    static final int MOD = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int dist = Math.abs(startPos - endPos) ;
        if(dist > k){
            return 0;
        }
        if(dist % 2 == 0 && k % 2 != 0){
            return 0;
        }
        if(dist % 2 != 0 && k % 2 == 0) return 0;        
        cnt = 0;     
        dp = new int[10001][k+1];
        for(int i = 0; i< dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return recurs(startPos, k, endPos);
        //return cnt;
    }
    public int recurs(int x, int step, int y){
        if(x == y && step == 0){
           return 1;
        }
        if(step <= 0) return 0;
        if(dp[x+1001][step] != -1) return dp[x+1001][step];
        return dp[x+1001][step] = (recurs(x-1, step-1, y) % MOD + recurs(x+1, step-1, y) % MOD)%MOD;
    }
}