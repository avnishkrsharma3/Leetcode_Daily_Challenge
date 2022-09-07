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
    StringBuilder str;
    public String tree2str(TreeNode root) {
        str = new StringBuilder();
        util(root);
        return str.toString().substring(1, str.length()-1);
    }
    
    public void util(TreeNode root){
        if(root != null && root.left == null && root.right == null){
            str.append('('); 
            str.append(root.val);
            str.append(')');
            return;
        }
        if(root == null){
            str.append('('); 
            str.append(')');
            return;
        }
        str.append('(');
        str.append(root.val);
        util(root.left);
        if(root.right != null)
        util(root.right);
        str.append(')');
        
    }
    
}