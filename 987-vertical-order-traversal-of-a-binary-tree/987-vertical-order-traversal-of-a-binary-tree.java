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

class Solution {
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
       List<List<Integer>> list = new ArrayList<>();
        util(root, 0);
        for(Map.Entry<Integer, TreeMap<Integer, PriorityQueue<Integer>>> entry : map.entrySet()){
            List<Integer> ll = entry.getValue();
            Collections.sort(ll);
            list.add(ll);
        }
        return list;
    }
    public void util(TreeNode root, int col){
        if(root == null)
            return;
        if(map.containsKey(col)){
            List<Integer> list = map.get(col);
            list.add(root.val);
            map.put(col, list);
        }
        else{
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(col, list);
        }
        util(root.left, col - 1);
        util(root.right, col + 1);
    }
}
*/
class Solution {
    class Tuples{
        int vLevel = 0;
        int depth = 0;
        TreeNode nd;
        Tuples(TreeNode nd, int vLevel, int depth ){
            this.nd = nd;
            this.vLevel = vLevel;
            this.depth = depth;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuples> q = new LinkedList<>();
        Tuples t = new Tuples(root, 0, 0);
        q.add(t);
        while(q.size() > 0){
             t = q.remove();
            int vLevel = t.vLevel;
            int depth  = t.depth;
            int value =  t.nd.val;
            if(!map.containsKey(vLevel)){
                map.put(vLevel, new TreeMap<>());
            }
            if(!map.get(vLevel).containsKey(depth)){
                map.get(vLevel).put(depth, new PriorityQueue<>());
            }
            map.get(vLevel).get(depth).add(value);
            if(t.nd.left != null){
                q.add(new Tuples(t.nd.left, vLevel- 1, depth+1));
            }
            if(t.nd.right != null){
                q.add(new Tuples(t.nd.right, vLevel+ 1, depth+1));
            }
        }
        List<List<Integer>> list = new ArrayList<>();
       for(TreeMap<Integer, PriorityQueue<Integer>> tm : map.values()){
           ArrayList<Integer> ll = new ArrayList<>();
           for(PriorityQueue<Integer> pq : tm.values()){
               while(pq.size() > 0){
                   ll.add(pq.remove());
               }
           }
           list.add(ll);
       }
        return list;
    }
}