class Solution {
    List<Integer> list;
    public int[] numsSameConsecDiff(int n, int k) {
        list = new ArrayList<>();
        for(int i = 1; i < 10; i++)
            util(n-1, k , i);
        int []arr = new int[list.size()];
         for(int i = 0; i < arr.length;i++){
             arr[i] = list.get(i);
         }
        return arr;
    }
    private void util(int n, int k, int p){
        if(n == 0){
            list.add(p); return;
        }
        int num = p % 10; 
        if(num - k >= 0 && k != 0){
             util(n-1, k, p*10+(num-k));
        }
        if(num + k < 10){
             util(n-1, k, p*10+(num+k));
        }
        return ;
    }
}