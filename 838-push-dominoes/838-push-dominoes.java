/*class Solution {
    StringBuilder sb;
    public String pushDominoes(String dominoes) {
        sb  = new StringBuilder();
        if(dominoes.length() == 1) return dominoes;
        for(int i = 0; i< dominoes.length(); i++){
            if(dominoes.charAt(i) != '.'){
                sb.append(dominoes.charAt(i));
            }
            else{
                util(dominoes, i);
            }
        }
        int i = 0;
        String ans = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        while(ans.charAt(i) == '.'){
            i++;
        }
        if(ans.charAt(i) == 'L'){
            while(i>=0){
                sb2.append('L');
            }
        }
        return sb.toString();
    }
    private void util(String str, int index){
        int left = index - 1;
        int right = index + 1;
        while(left >= 0 && right < str.length()){
 
            if(str.charAt(left) == 'R' && str.charAt(right) == 'L'){
                sb.append('.'); return;
            }
            else if(str.charAt(left) == 'L' && str.charAt(right) == 'R'){
                sb.append('.'); return;
            }
            else if(str.charAt(left) == 'R'){
                sb.append('R'); return;
            }
            else if(str.charAt(right) == 'L'){
                sb.append('L'); return;
            }
            else {
                left--; right++;
            }
        }
            if(left == -1){
                if(str.charAt(right) == 'L'){
                    sb.append('L'); return;
                }
                else{
                    sb.append('.'); return;
                }
            }
            if(right == str.length()){
                if(str.charAt(left) == 'R'){
                    sb.append('R'); return;
                }
                else{
                    sb.append('.'); return;
                }
            }
        }
}  */
class Solution {
    StringBuilder sb;
 public String pushDominoes(String dominoes) {
        
        char[] arr=new char[dominoes.length()+2];
        arr[0]='L';
        arr[arr.length-1]='R';
        for(int i=1;i<arr.length-1;i++){
            arr[i]=dominoes.charAt(i-1);
        }
        
        int i=0;
        int j=1;
        
        while(j!=arr.length){
            while(arr[j]=='.') j++;
            
            if(arr[i]=='L' && arr[j]=='L'){
                while(i!=j){
                    arr[i]='L';
                    i++;
                }
                j++;
            }else if(arr[i]=='L' && arr[j]=='R'){
                 i=j;
                 j++;
            }else if(arr[i]=='R' && arr[j]=='R'){
                while(i!=j){
                    arr[i]='R';
                    i++;
                }
                j++;
            }else if(arr[i]=='R' && arr[j]=='L'){
                 int temp1=i+1;
                 int temp2=j-1;
                 while(temp1<temp2){
                     arr[temp1]='R';
                     arr[temp2]='L';
                     temp1++;
                     temp2--;
                 }
                i=j;
                j++;
            }
        }
        
        StringBuilder sb=new StringBuilder("");
        for(i=1;i<arr.length-1;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}