public class leetcode145 {
    // link - https://leetcode.com/problems/binary-tree-postorder-traversal/description/
}

// Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        postOrder(root, ls);
        return ls;
    }
    private void postOrder(TreeNode root, List<Integer> ls){
        if(root == null) return;
        postOrder(root.left, ls);
        postOrder(root.right, ls);
        ls.add(root.val);
    }
}