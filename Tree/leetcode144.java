public class leetcode144 {
    // link - https://leetcode.com/problems/binary-tree-preorder-traversal/
}

// Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        preOrder(root, ls);
        return ls;
    }
    
    public void preOrder(TreeNode root, List<Integer> ls){
        if(root == null) return ;
        ls.add(root.val);
        preOrder(root.left, ls);
        preOrder(root.right, ls);
    }
}

// Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ls = new ArrayList<>();
        if(root == null)
            return ls;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            ls.add(root.val);
            if(root.right != null) st.push(root.right);
            if(root.left != null ) st.push(root.left);
        }
        return ls;
    }
}