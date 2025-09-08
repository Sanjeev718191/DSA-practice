public class BSTPredecessorSuccessor {
    // link - https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
}

class Solution {
    Node pre;
    Node suc;
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        pre = null;
        suc = null;
        dfs(root, key);
        ArrayList<Node> res = new ArrayList<>();
        res.add(pre);
        res.add(suc);
        return res;
    }
    private void dfs(Node root, int key) {
        if(root == null) return;
        if(root.data < key) {
            pre = root;
            dfs(root.right, key);
            return;
        } else if(root.data > key) {
            suc = root;
            dfs(root.left, key);
            return;
        } 
        if(root.left != null) {
            Node prev = root.left;
            while(prev != null) {
                pre = prev;
                prev = prev.right;
            }
        }
        if(root.right != null) {
            Node prev = root.right;
            while(prev != null) {
                suc = prev;
                prev = prev.left;
            }
        }
    }
}