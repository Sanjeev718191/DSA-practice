public class Kosaraju_StronglyConnected {
    // link - https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
}

class Solution {
    Stack<Integer> st;
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        st = new Stack<>();
        int n = adj.size();
        boolean vis[] = new boolean[n];
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            if(!vis[i]) dfs(adj, i, -1, vis);
            rev.add(new ArrayList<>());
        }
        for(int i = 0; i<n; i++) {
            for(int v : adj.get(i)) {
                rev.get(v).add(i);
            }
        }
        int count = 0;
        vis = new boolean[n];
        while(!st.isEmpty()) {
            int u = st.pop();
            if(!vis[u]) {
                finder(rev, u, -1, vis);
                count++;
            }
        }
        return count;
    }
    private void dfs(ArrayList<ArrayList<Integer>> grp, int u, int par, boolean vis[]) {
        vis[u] = true;
        for(int v : grp.get(u)) {
            if(u == par || vis[v]) continue;
            dfs(grp, v, u, vis);
        }
        st.push(u);
        return;
    }
    private void finder(ArrayList<ArrayList<Integer>> grp, int u, int par, boolean vis[]) {
        vis[u] = true;
        for(int v : grp.get(u)) {
            if(u == par || vis[v]) continue;
            finder(grp, v, u, vis);
        }
        return;
    }
}