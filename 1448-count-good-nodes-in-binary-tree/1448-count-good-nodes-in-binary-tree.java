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
    int cnt;
    public int goodNodes(TreeNode root) {
        cnt = 0;
        util(root, -10002);
        return cnt;
    }
    private void util(TreeNode root, int max){
        if(root == null)
            return ;
        if(root.val >= max){
            max = root.val;
            cnt += 1;
        }
        util(root.left, max);
        util(root.right, max);
    }
}