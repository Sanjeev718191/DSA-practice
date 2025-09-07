public class floorBST {
    // link - https://www.geeksforgeeks.org/problems/floor-in-bst/1
}

class Solution {
    public static int floor(Node root, int x) {
        // Code here
        if(root == null) return -1;
        if(root.data == x) return x;
        if(root.data > x) return floor(root.left, x);
        int r = floor(root.right, x);
        if(r != -1) return r;
        return root.data;
        
    }
}