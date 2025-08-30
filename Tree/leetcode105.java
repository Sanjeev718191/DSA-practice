public class leetcode105 {
    // link - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
}

class Solution {
    int ind = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i<n; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inMap, 0, n-1);
    }
    private TreeNode buildTree(int pre[], Map<Integer, Integer> in, int l, int r) {
        if(l > r) return null;
        TreeNode curr = new TreeNode(pre[ind++]);
        curr.left = buildTree(pre, in, l, in.get(curr.val)-1);
        curr.right = buildTree(pre, in, in.get(curr.val)+1,r);
        return curr;
    }
}