public class leetcode104 {
    // link - https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
}

// using BFS
class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            depth++;
            int s = q.size();
            for(int i = 0; i<s; i++){
                TreeNode curr = q.poll();
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
            }
        }
        return depth;
    }
}

// using dfs
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}