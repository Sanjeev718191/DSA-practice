public class leetcode827 {
    // link - https://leetcode.com/problems/making-a-large-island/description/
}

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int max = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] != 1) continue;
                int u = i*n + j;
                for(int d[] : dir) {
                    int x = i+d[0];
                    int y = j+d[1];
                    if(x<0 || y<0 || x>=n || y>=n || grid[x][y] == 0) continue;
                    int v = x*n + y;
                    ds.unionBySize(u, v);
                }
                max = Math.max(max, ds.size[ds.findParent(u)]);
            }
        }

        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                int sum = 0;
                HashSet<Integer> hs = new HashSet<>();
                if(grid[i][j] == 1) continue;
                int u = i*n + j;
                for(int d[] : dir) {
                    int x = i+d[0];
                    int y = j+d[1];
                    if(x<0 || y<0 || x>=n || y>=n || grid[x][y] == 0) continue;
                    int v = x*n + y;
                    int p = ds.findParent(v);
                    if(hs.contains(p)) continue;
                    sum += ds.size[p];
                    hs.add(p);
                }
                max = Math.max(max, sum+1);
            }
        }
        
        return max;
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