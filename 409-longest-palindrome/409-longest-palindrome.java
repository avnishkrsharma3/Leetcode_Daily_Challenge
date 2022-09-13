class Solution {
    public int longestPalindrome(String s) {
        int ans = 0;
        int [] arr = new int[256];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i)-'a'+50] += 1;
        }
        for(int i = 0; i< arr.length; i++){
            if(arr[i]%2 == 0){
                ans += arr[i];
            }
            else 
                ans += arr[i]-1;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i]%2 == 1){
                ans+= 1; break;
            }
        }
        return ans;
       /* for(int i = 0; i < s.length(); i++){
            ans = Math.max(ans, Math.max(util1(s, i), util2(s, i)));
        }
        return ans; */
    }
    /*
    public int util1(String s, int idx){
        int left = idx-1;
        int right = idx-1;
        int length = 1;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++; length += 2;
        }
        return length;
    }
    public int util2(String s, int idx){
        int left =  idx;
        int right = idx+1;
        int length = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--; right++; length += 2;
        }
        return length;  
    } */
}
// ddbb
// abcdcba => aabbccd
// abcddcba => aabbccdd