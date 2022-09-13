class Solution {
    String str;
    public String longestPalindrome(String s) {
        int ans = 0;
        str = "";
       // int [] 
        for(int i = 0; i < s.length(); i++){
            ans = Math.max(ans, Math.max(util1(s, i), util2(s, i)));
        }
        if(str.length() == 0)
            str += s.charAt(0);
        return str;
    }
     public int util1(String s, int idx){
        int left = idx-1;
        int right = idx-1;
        int length = 1;
         String temp;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
           
            temp = s.substring(left, right+1); left--; right++; length += 2;
            if(temp.length() >= str.length()){
                str = temp;
            }
        }
         left++; right--;
        return length;
    }
    public int util2(String s, int idx){
        int left =  idx;
        int right = idx+1;
        int length = 0;
        String temp;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
           
             temp = s.substring(left, right+1); left--; right++; length += 2;
            if(temp.length() >= str.length()){
                str = temp;
            }
        }
        return length;
    }
}