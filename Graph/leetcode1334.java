public class leetcode1334 {
    // link - https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
}

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], time = edge[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        int minCities = Integer.MAX_VALUE;
        int city = -1;

        for(int i = 0; i<n; i++) {
            int count = bfs(graph, i, distanceThreshold);
            if(count <= minCities) {
                minCities = count;
                city = i;
            }
        }

        return city;
    }
    private int bfs(List<List<int[]>> grp, int src, int max) {
        int n = grp.size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{src, 0});
        
        int dis[] = new int[n];
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

        int count = 0;
        for(int i : dis) {
            if(i<=max) count++;
        }
        return count;
    }
}