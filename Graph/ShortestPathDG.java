public class ShortestPathDG {
    // link - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
}

class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
        List<List<int[]>> grp = new ArrayList<>();
        for(int i = 0; i<V; i++) grp.add(new ArrayList());
        for(int edge[] : edges) {
            grp.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        boolean vis[] = new boolean[V];
        Stack<Integer> st = new Stack<>();
        dfs(grp, 0, vis, st);
        
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        
        while(!st.isEmpty()) {
            int u = st.pop();
            for(int v[] : grp.get(u)) {
                dis[v[0]] = Math.min(dis[v[0]], dis[u]+v[1]);
            }
        }
        
        for(int i = 0; i<V; i++) dis[i] = dis[i] == Integer.MAX_VALUE ? -1 : dis[i];
        
        return dis;
    }
    
    private void dfs(List<List<int[]>> grp, int u, boolean vis[], Stack<Integer> st) {
        vis[u] = true;
        for(int v[] : grp.get(u)) {
            if(!vis[v[0]]) dfs(grp, v[0], vis, st);
        }
        st.push(u);
    }
}