public class DSUUnionByRank {
    // link - https://takeuforward.org/plus/dsa/problems/disjoint-set-
    // time complexity = O(4 alpha) and alpha in nearly constant
    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}

class DisjointSet {
    int rank[], par[];
    public DisjointSet(int n) {
        rank = new int[n+1];
        par = new int[n+1];
        for(int i = 0; i<n; i++) {
            par[i] = i;
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
}
