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
    List<List<Integer>> ansList;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ansList = new ArrayList<>();
        util(root, 0, targetSum, new ArrayList<Integer>());
        return ansList;
    }
    
    public void util(TreeNode root, int sum, int targetSum, List<Integer> list){
       

        if(root == null) return;
        
        list.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == targetSum)
        {
            ansList.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        util(root.left, sum, targetSum, list );
        util(root.right, sum, targetSum, list);
        list.remove(list.size() - 1);
        
    }
}












