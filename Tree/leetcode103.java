public class leetcode103 {
    // link - http://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
}

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> ls = new ArrayList<>();
            for(int i = 0; i<s; i++){
                TreeNode curr = q.poll();
                ls.add(curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            if(reverse) {
                Collections.reverse(ls);
            }
            res.add(ls);
            reverse = !reverse;
        }
        return res;
    }
}