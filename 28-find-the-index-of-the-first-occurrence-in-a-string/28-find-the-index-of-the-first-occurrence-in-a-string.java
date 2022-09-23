class Solution {
    public int strStr(String haystack, String needle) {
         // int index = haystack.indexOf(needle);
         // return index;
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i  = 0; i < haystack.length(); i++){
            
            int index = i;
            if(haystack.charAt(i) == needle.charAt(0)){
              //  System.out.println(haystack.charAt(i) + " "+ i);
                if(check(haystack, i, needle)){
                    return i;
                }
            }
        }  
     return -1;
}
       public static boolean check(String str1, int i, String str2){
           int j = 0;
           int cnt = 0;
           while(j < str2.length() && i < str1.length() && str1.charAt(i) == str2.charAt(j)){
               System.out.println(str1.charAt(i));
                System.out.println(str2.charAt(j));
               i++;
               j++;
               cnt++;
           }
           if(cnt == str2.length())
               return true;
           else 
               return false;
       }
    
}

// hello             ll
// aaaaaaaaaa        aaaaaa
// a10               a7