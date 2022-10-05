
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        util(root, val, depth);
            return root;
    }
    private void util(TreeNode root, int val, int depth){
        Queue<TreeNode> q  = new LinkedList<TreeNode>();
        
        q.add(root);
        int level = 1;
        while(q.size() > 0){
            if(level == depth - 1){
                for(int i = 0;  i < q.size(); i++){
                    TreeNode node = q.remove();
                      TreeNode newLeft = new TreeNode(val);
                      TreeNode newRight = new TreeNode(val);
                      newLeft.left = node.left;
                      newRight.right = node.right;
                    node.right = newRight;
                    node.left = newLeft;
                }
            }else{
                int size = q.size();  // 2 5
                
                for(int i = 0; i< size; i++){
                    TreeNode node = q.remove();
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                }
                level++;
            }
        }
    }
}