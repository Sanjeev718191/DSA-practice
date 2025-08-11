public class leetcode721 {
    // link - https://leetcode.com/problems/accounts-merge/description/
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        HashMap<String, Integer> hm = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        int ind = 0;
        for(List<String> account : accounts) {
            for(int i = 1; i<account.size(); i++) {
                if(hm.containsKey(account.get(i))) {
                    ds.unionBySize(ind, hm.get(account.get(i)));
                } else {
                    hm.put(account.get(i), ind);
                }
            }
            ind++;
        }
        HashMap<Integer, List<String>> resMap = new HashMap<>();
        for(Map.Entry<String, Integer> e : hm.entrySet()) {
            int par = ds.findParent(e.getValue());
            if(!resMap.containsKey(par)) {
                resMap.put(par, new ArrayList<>());
            }
            resMap.get(par).add(e.getKey());
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> e : resMap.entrySet()) {
            List<String> curr = e.getValue();
            Collections.sort(curr);
            curr.add(0, accounts.get(e.getKey()).get(0));
            res.add(new ArrayList<>(curr));
        }

        return res;
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