public class BridgesInGrpLeetCode1192 {
    // link - https://leetcode.com/problems/critical-connections-in-a-network/description/
}

class Solution {
    int[] time, low;
    int timer;
    List<List<Integer>> bridges;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> grp = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            grp.add(new ArrayList<>());
        }
        for(List<Integer> connection : connections) {
            grp.get(connection.get(0)).add(connection.get(1));
            grp.get(connection.get(1)).add(connection.get(0));
        }
        time = new int[n];
        low = new int[n];
        timer = 1;
        bridges = new ArrayList<>();
        dfs(grp, 0, -1, new boolean[n]);
        return bridges;
    }
    private void dfs(List<List<Integer>> grp, int u, int par, boolean vis[]) {
        time[u] = low[u] = timer;
        vis[u] = true;
        timer++;
        for(int v : grp.get(u)) {
            if(v == par) continue;
            if(!vis[v]) {
                dfs(grp, v, u, vis);
                low[u] = Math.min(low[v], low[u]);
                if(time[u] < low[v]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[v], low[u]);
            }
        }
    }
}