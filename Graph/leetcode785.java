public class leetcode785 {
    // link - https://leetcode.com/problems/is-graph-bipartite/description/
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean vis[] = new boolean[n];
        int color[] = new int[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i] && !dfs(graph, n, vis, color, i)) return false;
        }
        return true;
    }
    private boolean dfs(int graph[][], int n, boolean vis[], int color[], int s) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(s);
        vis[s] = true;
        color[s] = 0;
        int col = 0;
        while(!que.isEmpty()) {
            col = col == 1? 0 : 1;
            int size = que.size();
            while(size-->0) {
                int u = que.poll();
                if(color[u] == col) return false;
                for(int v : graph[u]) {
                    if(vis[v]) {
                        if(color[v] == color[u]) return false;
                    } else {
                        color[v] = col;
                        vis[v] = true;
                        que.offer(v);
                    }
                }
            }
        }
        return true;
    }
}