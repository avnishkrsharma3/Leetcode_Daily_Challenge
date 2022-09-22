class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = 0; i < arr.length; i++){
            String str = arr[i];
            sb.append(reverse(str));
            if(i != arr.length - 1)
            sb.append(" ");
        }
        return sb.toString();
    }
    public String reverse(String s){
        if(s.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}