public class leetcode1008 {
    // link - https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length-1);
    }
    private TreeNode dfs(int preorder[], int l, int r) {
        if(l>r) return null;
        if(l == r) return new TreeNode(preorder[l]);
        TreeNode root = new TreeNode(preorder[l]);
        int m = l;
        for(int i = l+1; i<=r; i++) {
            if(preorder[l] < preorder[i]) {
                break;
            }
            m = i;
        }
        root.left = dfs(preorder, l+1, m);
        root.right = dfs(preorder, m+1, r);
        return root;
    }
}