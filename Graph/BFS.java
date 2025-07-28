public class BFS {
    // link - https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
}

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = adj.size();
        boolean vis[] = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        vis[0] = true;
        
        while(!que.isEmpty()) {
            int curr = que.poll();
            res.add(curr);
            for(int nxt : adj.get(curr)) {
                if(!vis[nxt]) {
                    vis[nxt] = true;
                    que.offer(nxt);
                }
            }
        }
        return res;
    }
}