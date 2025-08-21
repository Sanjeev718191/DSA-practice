public class leetcode102 {
    // link - https://leetcode.com/problems/binary-tree-level-order-traversal/description/
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new ArrayList<>();
        if(root == null) return ls;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int s = q.size();
            ArrayList<Integer> currLS = new ArrayList<>();
            for(int i = 0; i<s; i++){
                TreeNode curr = q.poll();
                currLS.add(curr.val);
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
            ls.add(currLS);
        }
        
        return ls;
    }
}