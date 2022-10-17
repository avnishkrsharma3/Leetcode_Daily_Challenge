class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        int arr[]  = new int[26];
        for(int i =0; i < sentence.length(); i++){
                arr[sentence.charAt(i) - 'a'] -= 1;
        }
        for(int i : arr){
            if(i == 0) return false;
        }
        return true;
    }
}