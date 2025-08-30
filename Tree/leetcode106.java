public class leetcode106 {
    // link - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
}

class Solution {
    int ind;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        ind = n-1;
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i<n; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(postorder, inMap, 0, n-1);
    }
    private TreeNode buildTree(int pre[], Map<Integer, Integer> in, int l, int r) {
        if(l > r || ind < 0) return null;
        TreeNode curr = new TreeNode(pre[ind--]);
        curr.right = buildTree(pre, in, in.get(curr.val)+1,r);
        curr.left = buildTree(pre, in, l, in.get(curr.val)-1);
        return curr;
    }
}