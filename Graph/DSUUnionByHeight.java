public class DSUUnionByHeight {
    // link - https://takeuforward.org/plus/dsa/problems/disjoint-set-
    // time complexity = O(4 alpha) and alpha in nearly constant
    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
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
