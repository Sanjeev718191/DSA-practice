public class KruskalsAlgo {
    // link - https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
}

class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        DisjointSet ds = new DisjointSet(V);
        int sum = 0;
        int count = 0;
        for(int edge[] : edges) {
            if(!ds.find(edge[0], edge[1])) {
                sum += edge[2];
                // ds.unionByRank(edge[0], edge[1]);
                ds.unionBySize(edge[0], edge[1]);
                count++;
            }
            if(count == V-1) break;
        }
        
        return sum;
    }
}

class DisjointSet {
    int rank[], par[], size[];
    public DisjointSet(int n) {
        rank = new int[n];
        par = new int[n];
        size = new int[n];
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

    public void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(rank[pu] > rank[pv]) {
            par[pv] = pu;
        } else if(rank[pu] == rank[pv]) {
            par[pv] = pu;
            rank[pu]++;
        } else {
            par[pu] = pv;
        }
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
