public class TreeBoundryTraversal {
    // link - https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
}

class Solution {
    ArrayList<Integer> res;
    void addLeft(Node root) {
        Node curr = root;
        while(curr != null) {
            if(curr.left == null && curr.right == null) break;
            res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    void addRight(Node root) {
        Node curr = root;
        List<Integer> ls = new ArrayList<>();
        while(curr != null) {
            if(curr.left == null && curr.right == null) break;
            ls.addFirst(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i : ls) res.add(i);
    }
    void addLeave(Node root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            res.add(root.data);
            return;
        }
        addLeave(root.left);
        addLeave(root.right);
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        this.res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.data);
        addLeft(root.left);
        if(!(root.left == null && root.right == null)) addLeave(root);
        addRight(root.right);
        return res;
    }
}