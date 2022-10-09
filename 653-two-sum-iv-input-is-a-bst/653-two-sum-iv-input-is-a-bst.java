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
    HashSet<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return inOrder(root, k);
    }
    private boolean inOrder(TreeNode root, int k){
        if(root == null) return false;
        boolean left = inOrder(root.left,  k);
        if(set.contains(k - root.val)) return true;
        set.add(root.val);
        boolean right = inOrder(root.right,  k);
        return left|| right;
    }
}






