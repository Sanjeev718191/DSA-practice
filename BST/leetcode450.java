public class leetcode450 {
    // link - https://leetcode.com/problems/delete-node-in-a-bst/description/
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            int val = getNode(root.left);
            root.val = val;
            root.left = deleteNode(root.left, val);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    private int getNode(TreeNode root) {
        if(root.right == null) {
            return root.val;
        }
        return getNode(root.right);
    }
}