public class ConnectedComponents {
    // link - https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
}

class Solution {
    ArrayList<Integer> res;
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> grp = new ArrayList<>();
        for(int i = 0; i<V; i++) grp.add(new ArrayList<>());
        
        for(int edge[] : edges) {
            grp.get(edge[0]).add(edge[1]);
            grp.get(edge[1]).add(edge[0]);
        }
        
        boolean vis[] = new boolean[V];
        for(int i = 0; i<V; i++) {
            if(!vis[i]) {
                res = new ArrayList<>();
                dfs(grp, vis, i);
                result.add(new ArrayList<>(res));
            }
        }
        return result;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int ind) {
        if(vis[ind]) return;
        vis[ind] = true;
        res.add(ind);
        for(int nxt : adj.get(ind)) dfs(adj, vis, nxt);
    }
}