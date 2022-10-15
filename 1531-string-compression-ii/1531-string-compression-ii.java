/*class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        HashMap <Character, Integer> lmap = new LinkedHashMap<>();
        int cnt = 1;
        for(int i = 0; i  < s.length(); i++){ // abccc // aabbccd
            if(i <= s.length() - 2){
                if(i == s.length() - 2){
                    if(s.charAt(i) == s.charAt(i+1)){
                        cnt++; lmap.put(s.charAt(i), cnt); cnt = 1; break;                        
                    }else{
                        lmap.put(s.charAt(i), cnt); lmap.put(s.charAt(i+1), 1); break;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(i+1)){
                        cnt++;
                    }else{
                        lmap.put(s.charAt(i), cnt); cnt = 1;
                    }
                }
            }
        }
        int arr [] = new int[lmap.size()]; int j = 0;
        for(Map.Entry<Character, Integer> entry : lmap.entrySet()){
            arr[j++] = entry.getValue();
            //System.out.println(entry.getValue());
        } 
        Arrays.sort(arr);
        for(int i = 0; i  < arr.length; i++){
        //   System.out.println(arr[i]);
            if(k <= 0) break;
            if(arr[i] - k <= 0){
             //  arr[i] = 0;
               k = k - arr[i];  arr[i] = 0;
            }
            else{
                arr[i] = arr[i] - k;
                k = 0;
            }
        } 
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
          //  System.out.println(arr[i]);
            if(arr[i] == 1 || arr[i] == 0){
                ans += arr[i];
            }
            else{
                 cnt = 1;
                while(arr[i] != 0){
                   arr[i]  =  arr[i]/10; cnt++;
                }
                ans += cnt;
            }
        }
      //  System.out.println(lmap);
        return ans;
    }
} */

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        // dp[i][k]: the minimum length for s[:i] with at most k deletion.
        int n = s.length();
        int[][] dp = new int[110][110];
        for (int i = 0; i <= n; i++) for (int j = 0; j <= n; j++) dp[i][j] = 9999;
		// for (int[] i : dp) Arrays.fill(i, n); // this is a bit slower (100ms)
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {                
                int cnt = 0, del = 0;
                for(int l = i; l >= 1; l--) { // keep s[i], concat the same, remove the different
                    if(s.charAt(l - 1) == s.charAt(i - 1)) cnt++;
                    else del++;
                    if(j - del >= 0) 
                        dp[i][j] = Math.min(dp[i][j], 
                                            dp[l-1][j-del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                }
                if (j > 0) // delete s[i]
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            }
        }
        return dp[n][k];
    }
}