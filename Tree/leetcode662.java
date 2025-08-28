public class leetcode662 {
    // link - https://leetcode.com/problems/maximum-width-of-binary-tree/description/
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        if(root == null) return maxWidth;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));

        while(!q.isEmpty()) {
            int s = q.size();
            int l = q.peek().getValue();
            int e = 0;
            while(s-- > 0) {
                Pair curr = q.poll();
                e = (int) curr.getValue();
                TreeNode currNode = (TreeNode) curr.getKey();
                if(currNode.left != null) 
                    q.offer(new Pair<>(currNode.left, 2*e));
                if(currNode.right != null) 
                    q.offer(new Pair<>(currNode.right, 2*e+1));
            }
            maxWidth = Math.max(maxWidth, e-l+1);
        }
        return maxWidth;
    }
}