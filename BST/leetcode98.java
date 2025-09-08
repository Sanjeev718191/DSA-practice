public class leetcode98 {
    // link - https://leetcode.com/problems/validate-binary-search-tree/description/
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if((root.left != null && root.left.val >= root.val) || 
            (root.right != null && root.right.val <= root.val)) return false;
        return check(root.left, Long.MIN_VALUE, (long)root.val) && check(root.right, (long)root.val, Long.MAX_VALUE);
    }
    private boolean check(TreeNode root, Long min, Long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return check(root.left, min, (long)root.val) && check(root.right, (long)root.val, max);
    }
}