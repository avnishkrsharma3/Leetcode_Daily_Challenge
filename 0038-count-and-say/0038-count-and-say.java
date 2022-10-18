class Solution {
    public String countAndSay(int n) {
        return util(n);
    }
    public String util(int n){
        if( n == 1){
            return "1";
        }
        String str = util(n-1);
      //  int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){ // 21
            int cnt = 1;
            while(i+1 < str.length()  &&  str.charAt(i) == str.charAt(i+1)){
                cnt++; i++;
                if(i == str.length()-1){
                   sb.append(cnt);
                   sb.append(str.charAt(i)); 
                    return sb.toString();
                }
            }
            sb.append(cnt);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}