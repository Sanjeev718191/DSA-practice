public class leetcode173 {
    // link - https://leetcode.com/problems/binary-search-tree-iterator/description/
}

class BSTIterator {
    List<Integer> inorder;
    int ind;
    public BSTIterator(TreeNode root) {
        this.inorder = new ArrayList<>();
        dfs(root);
        this.ind = 0;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        inorder.add(root.val);
        dfs(root.right);
    }
    
    public int next() {
        if(this.ind >= inorder.size()) return -1;
        ind++;
        return inorder.get(ind-1);
    }
    
    public boolean hasNext() {
        return this.ind < inorder.size();
    }
}