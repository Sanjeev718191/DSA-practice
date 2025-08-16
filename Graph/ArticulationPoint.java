public class ArticulationPoint {
    // link - https://www.geeksforgeeks.org/problems/articulation-point-1/1
}

class Solution {
    int[] time, low;
    int timer;
    boolean points[];
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> grp) {
        // Code here
        time = new int[n];
        low = new int[n];
        timer = 1;
        points = new boolean[n];
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i]) dfs(grp, i, -1, vis);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            if(points[i]) res.add(i);
        }
        if(res.size() == 0) res.add(-1);
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> grp, int u, int par, boolean vis[]) {
        time[u] = low[u] = timer;
        vis[u] = true;
        timer++;
        int child = 0;
        for(int v : grp.get(u)) {
            if(v == par) continue;
            if(!vis[v]) {
                dfs(grp, v, u, vis);
                low[u] = Math.min(low[v], low[u]);
                if(time[u] <= low[v] && par != -1) {
                    points[u] = true;
                }
                child++;
            } else {
                low[u] = Math.min(time[v], low[u]);
            }
        }
        if(child > 1 && par == -1) points[u] = true;
    }
}