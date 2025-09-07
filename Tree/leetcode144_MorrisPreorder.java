public class leetcode144_MorrisPreorder {
    // link - https://leetcode.com/problems/binary-tree-preorder-traversal/description/
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                ls.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if(prev.right == null) {
                    prev.right = curr;
                    ls.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return ls;
    }
}