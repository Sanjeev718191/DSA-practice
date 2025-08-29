public class leetcode222 {
    // link - https://leetcode.com/problems/count-complete-tree-nodes/description/
}

class Solution {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if(h < 0) return 0;
        return height(root.right) == h-1 ? (1 << h) + countNodes(root.right): 
                                           (1 << h-1) + countNodes(root.left);
    }
    private int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}