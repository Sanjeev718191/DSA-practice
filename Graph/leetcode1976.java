public class leetcode1976 {
    // link - https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()) {
            long curr[] = pq.poll();
            if(dist[(int)curr[1]] < curr[0]) continue;
            for(int nxt[] : graph.get((int)curr[1])) {
                if(dist[nxt[0]] == nxt[1] + curr[0]) {
                    ways[nxt[0]] = (ways[nxt[0]] + ways[(int)curr[1]])%1000000007;
                } else if(dist[nxt[0]] > nxt[1] + curr[0]) {
                    ways[nxt[0]] = ways[(int)curr[1]];
                    dist[nxt[0]] = nxt[1] + curr[0];
                    pq.offer(new long[]{nxt[1] + curr[0], nxt[0]});
                }
            } 
        }        

        return ways[n - 1];
    }
}