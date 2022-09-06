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
    public TreeNode pruneTree(TreeNode root) {
        if(root  == null) return null;
        if(util(root)){
            return root;
        }
        else{
            return null;
        }
    }
    private boolean util(TreeNode root){
        if(root == null)
            return false;
        boolean left = util(root.left);
        boolean right = util(root.right);
        if(left == false){
            root.left= null;
        }
        if(right == false){
            root.right = null;
        }
        if(left == true || right == true || root.val == 1)
            return true;
        else
            return false;
    }
}

// 0 -> 1