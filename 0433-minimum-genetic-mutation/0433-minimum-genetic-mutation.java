// class Solution {
//     public int minMutation(String start, String end, String[] bank) {
//         Queue<String> q = new LinkedList<>();
//         int [] arr = new int[bank.length];
//         q.add(start);
//         int cnt = 0;
//         boolean flag = false;
//         while(q.size() > 0){
//             int size = q.size();
//             while(size-- > 0){
//             String str = q.remove();
//             if(str.equals(end)) { return cnt;  }
//                for(int i = 0; i < bank.length; i++){
//                   if(arr[i] == 0 && check(bank[i], str)){
//                     q.add(bank[i]); arr[i] = -1;
//                 }
//               }
//             }
//             cnt++;
//         }
//        return -1;
//     }
//     public boolean check(String s1, String s2){
//         int cnt = 0;
//         for(int i = 0; i < s1.length(); i++){
//             if(s1.charAt(i) != s2.charAt(i)){
//                 cnt++;
//             }
//         }
//         return cnt < 2;
//     }
// }













class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int nodesInQueue = queue.size();
            for (int j = 0; j < nodesInQueue; j++) {
                String node = queue.remove();
                if (node.equals(end)) {
                    return steps;
                }

                for (char c: new char[] {'A', 'C', 'G', 'T'}) {
                    for (int i = 0; i < node.length(); i++) {
                        String neighbor = node.substring(0, i) + c + node.substring(i + 1);
                        if (!seen.contains(neighbor) && Arrays.asList(bank).contains(neighbor)) {
                            queue.add(neighbor);
                            seen.add(neighbor);
                        }
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}