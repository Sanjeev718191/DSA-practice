public class leetcode101 {
    // link - https://leetcode.com/problems/symmetric-tree/description/
}

class Solution {
    boolean checkInverse(TreeNode ln, TreeNode rn){
        if(ln == null && rn == null)
            return true;
        if((ln == null && rn != null) || (ln != null && rn == null))
            return false;
        if(!checkInverse(ln.left, rn.right) || !checkInverse(ln.right, rn.left))
            return false;
        return ln.val == rn.val;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
		    return true;
		return checkInverse(root.left, root.right);
    }
}