public class leetcode778 {
    // link - https://leetcode.com/problems/swim-in-rising-water/description/
}

// Solution using Binary search and DFS
class Solution {
    int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0, r = n*n;
        while(l<=r) {
            int m = (l+r)/2;
            if(dfs(grid, m, 0, 0, new boolean[n][n])) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l;
    }
    private boolean dfs(int grid[][], int limit, int i, int j, boolean vis[][]) {
        if(i<0 || j<0 || i>=grid.length || j>=grid.length || vis[i][j] || grid[i][j] > limit) return false;
        if(i == grid.length-1 && j == grid.length-1) return true;

        vis[i][j] = true;
        for(int d[] : dir) {
            if(dfs(grid, limit, i+d[0], j+d[1], vis)) return true;
        }

        return false;
    }
}

// Solution using DSU
class Solution {
    int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<int[]> ls = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                ls.add(new int[]{i, j, grid[i][j]});
            }
        }
        Collections.sort(ls, (a,b) -> a[2]-b[2]);

        boolean vis[][] = new boolean[n][n];
        DisjointSet ds = new DisjointSet(n*n);

        for(int i = 0; i<n*n; i++) {
            int curr[] = ls.get(i);
            vis[curr[0]][curr[1]] = true;
            int ind = curr[0]*n+curr[1];
            for(int d[] : dir) {
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];
                if(x<0 || y<0 || x>=n || y>=n || !vis[x][y]) continue;
                ds.unionBySize(x*n+y, ind);
            }
            if(ds.find(0, (n*n)-1)) return curr[2];
        }

        return -1;
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