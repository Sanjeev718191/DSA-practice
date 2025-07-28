public class DFS {
    // link - https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
}

class Solution {
    ArrayList<Integer> res;
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        res = new ArrayList<>();
        int n = adj.size();
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i]) dfs(adj, vis, i);
        }
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int ind) {
        if(vis[ind]) return;
        vis[ind] = true;
        res.add(ind);
        for(int nxt : adj.get(ind)) dfs(adj, vis, nxt);
    }
}