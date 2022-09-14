/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt ;
  
    public int pseudoPalindromicPaths (TreeNode root) {
        cnt = 0;       
        dfs(root, new int[10]);
        return cnt;
    }
    
    private void dfs(TreeNode root, int [] arr){
        if(root == null) return;
        if(root.left == null && root.right == null){
            int odd = 0; 
            arr[root.val] += 1;
            for(int i : arr){
               //  System.out.println(i);
                 if(odd >= 1 && i % 2 == 1){
                     arr[root.val] -= 1;
                     return;
                 }
                 else if(i % 2 == 1){
                     odd++;
                 }
             }
            cnt++;
            arr[root.val] -= 1;
             return;
        }
            arr[root.val] += 1;
            dfs(root.right, arr);
            dfs(root.left, arr);
            arr[root.val] -= 1;
    }
    private boolean check(List<Integer>list){
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean flag = true;
        for(int i : list){
            map.put(i, map.getOrDefault(i, 0 ) + 1);
        }
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            int val = it.getValue();
            if(val % 2 == 1 && flag){
                flag = false;
            }
            else if(val % 2 == 1 && flag == false){
                return false;
            }
        }
        return true;
    }
    // aaaccc
    // aca a aca
}