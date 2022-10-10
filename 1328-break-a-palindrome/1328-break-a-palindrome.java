class Solution {
    
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";
        int index = -1;
        
        for(int i = 0; i < palindrome.length(); i++){
            if(palindrome.charAt(i) == 'a'){
                continue;
            }
            else{
                index = i; break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < palindrome.length(); i++){
            char ch = palindrome.charAt(i);
            if(i == index){
                sb.append('a');
            }else{
                sb.append(ch);
            }
        }
        int index2 = -1;
       for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == 'a'){
                continue;
            }
            else{
                index2 = i; break;
            }
        }
        if(index2 == -1){
            String ans = palindrome.substring(0, index + 1);
            ans += palindrome.substring(index+1, palindrome.length() - 1);
            ans += 'b';
            ///System.out.println("b");
            return ans;
        }
        
        return sb.toString();
    }
    
}