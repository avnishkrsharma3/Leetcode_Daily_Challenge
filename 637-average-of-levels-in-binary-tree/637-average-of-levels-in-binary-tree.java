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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            int tempSize=size;
            double d = 0.0;
            while(size-- > 0){
                TreeNode node = q.remove();
                if(node.left!= null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
                d += (double)node.val;
            }
            list.add(d/tempSize);
        }
        return list;
    }
}