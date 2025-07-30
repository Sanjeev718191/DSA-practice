public class CycleDetection {
    // link - https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
}

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[]=new boolean[V];
        
        for(int x=0;x<V;x++){
            if(!vis[x]){
                if(dfs(x,adj,vis,-1))return true;
            }
        }
        return false;
    }
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean vis[],int parent){
        vis[v]=true;
        for(int neighbor:adj.get(v)){
            if(!vis[neighbor]){
                if(dfs(neighbor,adj,vis,v))return true;
            }
            else if(parent!=neighbor){
                return true;
            }
        }
        return false;
    }
}



class Solution {
    class pair{
        int par, val;
        pair(int p, int v){
            par = p;
            val = v;
        }
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i<V; i++){
            if(!vis[i]){
                q.add(new pair(-1, i));
                if(bfdBidirectionl(q, vis, adj))
                    return true;
            }
        }
        return false;
    }
    private boolean bfdBidirectionl(Queue<pair> q, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        while (!q.isEmpty()){
            int par = q.peek().par;
            int val = q.peek().val;
            vis[val] = true;
            q.poll();
            for(int i : adj.get(val)){
                if(vis[i] == true && i != par) return true;
                if(!vis[i]) q.add(new pair(val, i));
            }
        }
        return false;
    }
    
}