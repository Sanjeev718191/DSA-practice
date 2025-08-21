public class leetcode94 {
    // link - https://leetcode.com/problems/binary-tree-inorder-traversal/description/
}

// Recursive 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        inOrder(root, ls);
        return ls;
    }
    private void inOrder(TreeNode root, List<Integer> ls){
        if(root == null) return;
        inOrder(root.left, ls);
        ls.add(root.val);
        inOrder(root.right, ls);
    }
}