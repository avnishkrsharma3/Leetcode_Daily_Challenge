class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return util(root,0, targetSum);
    }
    private boolean util(TreeNode root,int sum, int targetSum){
        if(root == null) return false;
        if(sum + root.val == targetSum  && root.left == null && root.right == null)
            return true;
        return (util(root.left, sum + root.val, targetSum) || util(root.right, sum + root.val , targetSum));
    }
}




