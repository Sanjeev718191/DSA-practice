public class leetcode543 {
    // link - https://leetcode.com/problems/diameter-of-binary-tree/description/
}

class Solution {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        this.diameter = 0;
        if(root == null) return this.diameter;
        getMaxDiameter(root);
        return this.diameter;
    }
    private int getMaxDiameter(TreeNode root) {
        if(root == null) return 0;
        int l = getMaxDiameter(root.left);
        int r = getMaxDiameter(root.right);
        this.diameter = Math.max(this.diameter, l+r);
        return Math.max(l,r)+1;
    }
}