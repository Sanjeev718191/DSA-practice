public class leetcode653 {
    // link - https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
}

class Solution {
    Set<Integer> inorder;
    public boolean findTarget(TreeNode root, int k) {
        this.inorder = new HashSet<>();
        return dfs(root, k);
    }
    private boolean dfs(TreeNode root, int k) {
        if(root == null) return false;
        if(dfs(root.left, k) || inorder.contains(k-root.val)) return true;
        inorder.add(root.val);
        return dfs(root.right, k);
    }
}