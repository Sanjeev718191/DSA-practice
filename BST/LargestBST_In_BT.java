public class LargestBST_In_BT {
    // link - https://www.geeksforgeeks.org/problems/largest-bst/1
}

// Naive Approach  {Time - N^2}
class Solution {
    static int max;
    static int largestBst(Node root) {
        if(root == null) return 0;
        max = 1;
        dfs(root);
        return max;
    }
    private static void dfs(Node root) {
        if(root == null) return;
        max = Math.max(max, isValidBST(root));
        dfs(root.left);
        dfs(root.right);
    }
    private static int isValidBST(Node root) {
        if(root == null) return 0;
        if((root.left != null && root.left.data >= root.data) || 
            (root.right != null && root.right.data <= root.data)) return -1;
        int l = check(root.left, Long.MIN_VALUE, (long)root.data);
        if(l == -1) return -1;
        int r = check(root.right, (long)root.data, Long.MAX_VALUE);
        if(r == -1) return -1;
        return  l+r+1;
    }
    private static int check(Node root, Long min, Long max) {
        if(root == null) return 0;
        if(root.data <= min || root.data >= max) return -1;
        int l = check(root.left, min, (long)root.data);
        if(l == -1) return -1;
        int r = check(root.right, (long)root.data, max);
        if(r == -1) return -1;
        return  l+r+1;
    }
}

// Efficent approach  {Time - N}

class Solution {
    static class Data {
        int min, max, size;
        Data(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        Data d = getBst(root);
        return d.size;
    }
    static Data getBst(Node root) {
        if(root == null) {
            return new Data(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        } 
        Data l = getBst(root.left);
        Data r = getBst(root.right);
        if(l.max < root.data && r.min > root.data) {
            return new Data(Math.min(l.min, root.data), Math.max(r.max, root.data), l.size + r.size + 1);
        }
        return new Data(Integer.MIN_VALUE,Integer.MAX_VALUE, Math.max(l.size, r.size));
    }
}