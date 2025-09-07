public class CeilBST {
    // link - https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
}

class Solution {
    int findCeil(Node root, int x) {
        // code here
        if(root == null) return -1;
        if(root.data == x) return x;
        if(root.data < x) return findCeil(root.right, x);
        int l = findCeil(root.left, x);
        if(l != -1) return l;
        return root.data;
    }
}