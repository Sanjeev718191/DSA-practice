public class leetcode802 {
    // link - https://leetcode.com/problems/find-eventual-safe-states/description/
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i]) dfs(graph, i, vis, pathVis);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<n; i++) if(!pathVis[i]) res.add(i);
        return res;
    }
    private boolean dfs(int grp[][], int u, boolean vis[], boolean pathVis[]) {
        if(pathVis[u]) return true;
        if(vis[u]) return false;
        vis[u] = true;
        pathVis[u] = true;
        for(int v : grp[u]) {
            if(dfs(grp, v, vis, pathVis)) return true;
        }
        pathVis[u] = false;
        return false;
    }
}