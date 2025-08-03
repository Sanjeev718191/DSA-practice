public class TopoSort {
    // link - https://www.geeksforgeeks.org/problems/topological-sort/1
}

class Solution {
    public static ArrayList<Integer> topoSort(int n, int[][] edges) {
        List<List<Integer>> grp = new ArrayList<>();
        for(int i = 0; i<n; i++) grp.add(new ArrayList<>());
        int inDeg[] = new int[n];
        for(int edge[] : edges) {
            inDeg[edge[1]]++;
            grp.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i] && inDeg[i] == 0) {
                dfs(grp, i, vis, pathVis, inDeg, res);
            } 
        }
        return res;
    }
    public static boolean dfs(List<List<Integer>> grp, int curr, boolean vis[], boolean pathVis[], int inDeg[], ArrayList<Integer> res) {
        if(pathVis[curr]) return true;
        if(vis[curr]) return false;
        vis[curr] = true;
        pathVis[curr] = true;
        res.add(curr);
        for(int nxt : grp.get(curr)) {
            inDeg[nxt]--;
            if(inDeg[nxt] == 0 && dfs(grp, nxt, vis, pathVis, inDeg, res)) return true;
        }
        pathVis[curr] = false;
        return false;
    }
}