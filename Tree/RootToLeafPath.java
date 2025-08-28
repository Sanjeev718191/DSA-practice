public class RootToLeafPath {
    // link - https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
}

class Solution {
    static ArrayList<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        res = new ArrayList<>();
        dfs(root, new ArrayList<>());
        return res;
    }
    private static void dfs(Node root, List<Integer> ls) {
        if(root == null) return;
        ls.add(root.data);
        if(root.left == null && root.right == null) res.add(new ArrayList<>(ls));
        dfs(root.left, ls);
        dfs(root.right, ls);
        ls.remove(ls.size()-1);
    }
}