/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                ll.add(n.val);
                List<Node> l = n.children;
                for (int j = 0; j < l.size(); j++) {
                    Node node = l.get(j);
                       q.add(node);
                }
            }
            list.add(ll);
        }
        
        return list;
    }
    
}
