public class ShortestPathUD {
    // link - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
}


class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int pathLen[] = new int[n];
        Arrays.fill(pathLen, Integer.MAX_VALUE);
        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        int d = 0;
        while(!q.isEmpty()) {
            int s = q.size();
            for(int i = 0; i<s; i++) {
                int curr = q.poll();
                vis[curr] = true;
                pathLen[curr] = Math.min(d, pathLen[curr]);
                for(int nxt : adj.get(curr)) {
                    if(vis[nxt]) continue;
                    q.offer(nxt);
                }
            }
            d++;
        }
        for(int i = 0; i<n; i++) pathLen[i] = pathLen[i] == Integer.MAX_VALUE ? -1 : pathLen[i];
        return pathLen;
    }
}