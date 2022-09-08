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
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stk = new Stack<>();
        HashSet<TreeNode> set = new HashSet<>();
        stk.push(root);
        while(stk.size() > 0){
            if(stk.peek().left == null || set.contains(stk.peek().left) ){
                TreeNode node = stk.pop();
                list.add(node.val);
                set.add(node);
                if(node.right != null){
                    stk.push(node.right);
                }
            }
            else{
                stk.push(stk.peek().left);
            }
        }
        
        return list;
    }
    private void util(TreeNode root){
        if(root == null) return ;
        util(root.left);
        list.add(root.val);
        util(root.right);
    }
}