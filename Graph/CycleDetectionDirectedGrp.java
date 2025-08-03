public class CycleDetectionDirectedGrp {
    // link - https://takeuforward.org/plus/dsa/problems/detect-a-cycle-in-a-directed-graph
}

class Solution {
    public boolean isCyclic(int n, List<Integer>[] adj) {
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i]) {
                if(dfs(adj, i, vis, pathVis)) return true;
            }
        }
        return false;
    }
    private boolean dfs(List<Integer>[] adj, int curr, boolean vis[], boolean pathVis[]) {
        if(pathVis[curr]) return true;
        if(vis[curr]) return false;
        vis[curr] = true;
        pathVis[curr] = true;
        for(int nxt : adj[curr]) {
            if(dfs(adj, nxt, vis, pathVis)) return true;
        }
        pathVis[curr] = false;
        return false;
    }
}
