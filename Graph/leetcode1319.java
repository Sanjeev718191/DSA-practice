public class leetcode1319 {
    // link - https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
}

// Naive approach using DFS
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m < n-1) return -1;
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
        for(int i = 0; i<n; i++) ls.add(new ArrayList<>());
        for(int a[] : connections){
            ls.get(a[0]).add(a[1]);
            ls.get(a[1]).add(a[0]);
        }
        int countConnected = 0;
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++){
            if(!vis[i]){
                countConnected++;
                dfs(ls, i, vis);
            }
        }
        return countConnected-1;
    }
    private void dfs(ArrayList<ArrayList<Integer>> grp, int curr, boolean vis[]){
        if(curr >= vis.length || vis[curr]) return;
        vis[curr] = true;
        for(int child : grp.get(curr)) dfs(grp, child, vis);
    }
}

// optimized solution using DSU 
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        if(m < n-1) return -1;

        int extraEdges = 0;
        DisjointSet ds = new DisjointSet(n);
        
        for(int connection[] : connections){
            if(ds.find(connection[0], connection[1])) {
                extraEdges++;
            } else {
                ds.unionBySize(connection[0], connection[1]);
            }
        }
        
        int countParent = 0;
        for(int i = 0; i<n; i++){
            if(ds.par[i] == i) countParent++;
        }
        if(extraEdges < countParent-1) return -1;
        return countParent-1;
    }
}

class DisjointSet {
    int par[], size[];
    public DisjointSet(int n) {
        par = new int[n+1];
        size = new int[n+1];
        for(int i = 0; i<n; i++) {
            par[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int u) {
        if(par[u] == u) return u;
        int p = findParent(par[u]);
        par[u] = p; // path compression
        return p;
    }

    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(size[pu] >= size[pv]) {
            par[pv] = pu;
            size[pu] += size[pv];
        } else {
            par[pu] = pv;
            size[pv] += size[pu];
        }
    }
}