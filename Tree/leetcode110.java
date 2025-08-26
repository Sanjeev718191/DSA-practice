public class leetcode110 {
    // link - https://leetcode.com/problems/balanced-binary-tree/description/
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return getHeight(root) != -1;
    }
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        int l = getHeight(root.left);
        if(l == -1) return -1;
        int r = getHeight(root.right);
        if(r == -1) return -1;
        return Math.abs(l-r) < 2 ? Math.max(l, r)+1 : -1;
    }
}