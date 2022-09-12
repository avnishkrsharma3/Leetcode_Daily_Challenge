class Solution {
    
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0;
        boolean flag = true; //  true is for face up
        int left = 0; 
        int right = tokens.length -1;
        int score = 0;
        while(left <= right){
            if(power < tokens[left] && score == 0){
                break;
            }             
            if(tokens[left] <= power){
                     score++;
                     flag = false; // down
                     power -= tokens[left];
                     left++;
                 }
            else{
                 if(score > 0){
                     score--;
                     flag = true; // up
                     power += tokens[right];
                     right--;
                 }
            }
            ans = Math.max(ans, score);
        }
        return ans = Math.max(ans, score);
    }
    
}