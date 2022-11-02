class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> q = new LinkedList<>();
        int [] arr = new int[bank.length];
        q.add(start);
        int cnt = 0;
        boolean flag = false;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
            String str = q.remove();
            if(str.equals(end)) { return cnt;  }
               for(int i = 0; i < bank.length; i++){
                  if(arr[i] == 0 && check(bank[i], str)){
                    q.add(bank[i]); arr[i] = -1;
                }
              }
            }
            cnt++;
        }
       return -1;
    }
    public boolean check(String s1, String s2){
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                cnt++;
            }
        }
        return cnt < 2;
    }
}

