public class ChildSum {
    // link - https://www.geeksforgeeks.org/problems/children-sum-parent/1
}

class Solution {
    public boolean isSumProperty(Node root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int sum = 0;
        if(root.left != null) {
            sum = root.left.data;
        }
        if(root.right != null) {
            sum += root.right.data;
        }
        if(root.data != sum || !isSumProperty(root.left) || !isSumProperty(root.right)) return false;
        return true;
    }
}