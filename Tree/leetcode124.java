public class leetcode124 {
    // link - https://leetcode.com/problems/binary-tree-maximum-path-sum/
}

class Solution {
    int sum;
    public int maxPathSum(TreeNode root) {
        this.sum = Integer.MIN_VALUE;
        if(root == null) return this.sum;
        getMaxSum(root);
        return this.sum;
    }
    private int getMaxSum(TreeNode root) {
        if(root == null) return 0;
        int l = Math.max(getMaxSum(root.left), 0);
        int r = Math.max(getMaxSum(root.right), 0);
        this.sum = Math.max(this.sum, l+r+root.val);
        return Math.max(l,r)+root.val;
    }
}