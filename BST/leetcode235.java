public class leetcode235 {
    // link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode min, max;
        if(p.val < q.val) {
            min = p;
            max = q;
        } else {
            min = q;
            max = p;
        }
        return dfs(root, min, max);
    }
    private TreeNode dfs(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) return null;
        if(root.val >= min.val && root.val <= max.val) return root;
        if(root.val > max.val) return dfs(root.left, min, max);
        return dfs(root.right, min, max);
    }
}