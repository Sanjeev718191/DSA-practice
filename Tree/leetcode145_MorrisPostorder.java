public class leetcode145_MorrisPostorder {
    // link - https://leetcode.com/problems/binary-tree-postorder-traversal/description/
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.right == null) {
                ls.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode prev = curr.right;
                while(prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }
                if(prev.left == null) {
                    prev.left = curr;
                    ls.add(curr.val);
                    curr = curr.right;
                } else {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(ls);
        return ls;
    }
}