public class leetcode99 {
    // link- https://leetcode.com/problems/recover-binary-search-tree/description/
}

class Solution {
    TreeNode prev, fst, scd;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        getNodes(root);
        if(fst != null && scd != null) {
            int temp = fst.val;
            fst.val = scd.val;
            scd.val = temp;
        }
    }
    private void getNodes(TreeNode root) {
        if(root == null) return;
        getNodes(root.left);
        if(prev != null && root.val < prev.val) {
            if(fst == null) fst = prev;
            scd = root;
        }
        prev = root;
        getNodes(root.right);
    }
}