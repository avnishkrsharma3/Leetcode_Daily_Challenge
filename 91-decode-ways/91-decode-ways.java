class Solution {
   // ArrayList<Integer> list;
    int dp[] ;
    public int numDecodings(String s) {
       // char charArr[] = s.toCharArray();
        dp = new int[s.length() + 2];
        if(s.charAt(0) == '0') return 0;
        return util(s, 0);
    }
    private int util(String s, int idx){
        if(idx == s.length())
            return 1;
        if(idx >= s.length())
            return 0;
         // StringBuilder temp = new StringBuilder();
        if(dp[idx] != 0) return dp[idx];
        int cnt = 0;
        for(int i = idx+1; i <= s.length(); i++){
            String temp = s.substring(idx, i);
            int val  = Integer.parseInt(temp);
            if(val > 26 || val == 0) break;
            cnt = cnt +  util(s, i) ;
        }
        return dp[idx] = cnt;
    }
   // "2 2 6"
    // 2 2 6
}