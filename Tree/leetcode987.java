public class leetcode987 {
    // link - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
}

class Solution {
    class Pair {
        TreeNode root;
        int x, y;
        Pair(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0; i<s; i++){
                Pair curr = q.poll();
                map.computeIfAbsent(curr.x, k -> new TreeMap<>())
                   .computeIfAbsent(curr.y, k -> new ArrayList<>())
                   .add(curr.root.val);
                if(curr.root.left != null)
                    q.offer(new Pair(curr.root.left, curr.x-1, curr.y+1));
                if(curr.root.right != null)
                    q.offer(new Pair(curr.root.right, curr.x+1, curr.y+1));
            }
        }
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> curr : map.entrySet()) {
            List<Integer> ls = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> e : curr.getValue().entrySet()) {
                Collections.sort(e.getValue());
                ls.addAll(e.getValue());
            }
            res.add(ls);
        }
        return res;
    }
}