public class leetcode743 {
    // link - https://leetcode.com/problems/network-delay-time/description/
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> grp = new ArrayList<>();
        for(int i = 0; i<n+1; i++) {
            grp.add(new ArrayList<>());
        }
        for(int edge[] : times) {
            grp.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{k, 0});
        
        int dis[] = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;
        
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            for(int nxt[] : grp.get(curr[0])) {
                if(dis[nxt[0]] > curr[1]+nxt[1]) {
                    dis[nxt[0]] = curr[1]+nxt[1];
                    pq.offer(new int[]{nxt[0], dis[nxt[0]]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        dis[0] = Integer.MIN_VALUE;
        for(int d : dis) max = Math.max(d, max);
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}