class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ' || i == s.length()-1){
              if(s.length() - 1== i){
                  sbb.append(s.charAt(i));   
                  sb.append(sbb.reverse());
                  break;
              }
              else{
                   sb.append(sbb.reverse());
                   sb.append(s.charAt(i));
                   sbb = new StringBuilder();
              }             
            }
            else sbb.append(s.charAt(i));
        }
        return sb.toString();
    }
}