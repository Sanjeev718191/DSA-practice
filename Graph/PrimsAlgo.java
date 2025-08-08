public class PrimsAlgo {
    // link - https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
}

class Solution {
    public int spanningTree(int V, int[][] edges) {
        List<List<int[]>> grp = new ArrayList<>();
        for(int i = 0; i<V; i++) {
            grp.add(new ArrayList<>());
        }
        for(int edge[] : edges) {
            grp.get(edge[0]).add(new int[]{edge[1], edge[2]});
            grp.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        int sum = 0;
        boolean vis[] = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{-1, 0, 0});
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            if(vis[curr[1]]) continue;
            sum += curr[2];
            vis[curr[1]] = true;
            for(int nxt[] : grp.get(curr[1])) {
                pq.offer(new int[]{curr[1], nxt[0], nxt[1]});
            }
        }
        return sum;
    }
}