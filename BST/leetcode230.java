public class leetcode230 {
    // link - https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
}

class Solution {
    int res = -1;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        if(k == 0) return root.val;
        dfs(root, k);
        return res;
    }
    private void dfs(TreeNode root, int k) {
        if(root == null) return;
        dfs(root.left, k);
        if(count > k) return;
        else if(count+1 == k && res == -1) {
            res = root.val;
        }
        count++;
        dfs(root.right, k);
    }
}