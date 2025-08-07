public class BellmanFordAlgo {
    // link - https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
}

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        int dis[] = new int[V];
        int infinite = (int)1e8;
        Arrays.fill(dis, infinite);
        dis[src] = 0;
        
        for(int i = 0; i<V; i++) {
            for(int edge[] : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(dis[u] != infinite && dis[u] + wt < dis[v]) {
                    if(i == V-1) return new int[]{-1};
                    dis[v] = dis[u] + wt;
                }
            }
        }
        
        return dis;
    }
}
