public class DijkstraAlgo {
    // link - https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> grp = new ArrayList<>();
        for(int i = 0; i<V; i++) {
            grp.add(new ArrayList<>());
        }
        for(int edge[] : edges) {
            grp.get(edge[0]).add(new int[]{edge[1], edge[2]});
            grp.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{src, 0});
        
        int dis[] = new int[V];
        Arrays.fill(dis, (int)1e9);
        dis[src] = 0;
        
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            for(int nxt[] : grp.get(curr[0])) {
                if(dis[nxt[0]] > curr[1]+nxt[1]) {
                    dis[nxt[0]] = curr[1]+nxt[1];
                    pq.offer(new int[]{nxt[0], dis[nxt[0]]});
                }
            }
        }
        
        return dis;
        
    }
}