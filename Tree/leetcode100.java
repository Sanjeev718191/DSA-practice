public class leetcode100 {
    // link - https://leetcode.com/problems/same-tree/description/
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  return true;
        if(q == null || p == null || p.val != q.val)  return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
}