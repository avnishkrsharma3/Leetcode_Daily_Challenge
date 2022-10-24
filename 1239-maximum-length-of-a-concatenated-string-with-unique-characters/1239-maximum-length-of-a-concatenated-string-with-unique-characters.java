class Solution {
    public int maxLength(List<String> arr) {
       int ans = util(arr, 0, "");
        return ans;
    }
    
    private int util(List<String> list, int idx, String str){
        
        if(idx == list.size()){
           // System.out.println(str);
            if(isSame(str, ""))
                return 0;
            else
                return str.length();
        }  
        String  st = list.get(idx);
        int a = 0, b = 0;
        if(!isSame(st, str)) {
             a = util(list, idx + 1, str + st);
             b = util(list, idx + 1, str);
        }
        else
         b = util(list, idx + 1, str);
            return Math.max(a,b);        
    }
    
    private boolean isSame(String str1, String str2){
        String st = str1 + str2;
        for(int i = 0; i < st.length(); i++){
            for(int j = i+1; j < st.length(); j++){
                if(st.charAt(i) == st.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }
    
}