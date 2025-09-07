public class leetcode114 {
    // link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
}

class Solution {
    TreeNode newRoot;
    TreeNode nxt;
    public void flatten(TreeNode root) {
        newRoot = new TreeNode(-1);
        nxt = newRoot;
        dfs(root);
        root = newRoot.right;
    }
    private void dfs(TreeNode root) {
        if(root == null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        nxt.right = root;
        nxt = nxt.right;
        root.left = null;
        dfs(l);
        dfs(r);
    }
}