public class leetcode947 {
    // link - https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
}

// Naive
class Solution {
    public int removeStones(int[][] stones) {
        boolean vis[] = new boolean[stones.length];
        int grps = 0;
        for(int i = 0; i<stones.length; i++) {
            if(!vis[i]) {
                grps++;
                dfs(stones, i, vis);
            }
        }
        return stones.length - grps;
    }
    private void dfs(int[][] s, int ind, boolean vis[]) {
        if(vis[ind]) return;
        vis[ind] = true;
        for(int i = 0; i<s.length; i++) {
            if(i != ind && (s[ind][0] == s[i][0] || s[ind][1] == s[i][1])) dfs(s, i, vis);
        }
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int stone[] : stones) { 
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        Set<Integer> set = new HashSet<>();
        for(int stone[] : stones){
            ds.unionBySize(stone[0], maxRow + stone[1]);
            set.add(stone[0]);
            set.add(maxRow + stone[1]);
        }
        
        int countParent = 0;
        for(int i : set){
            if(ds.findParent(i) == i) countParent++;
        }
        return stones.length - countParent;
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