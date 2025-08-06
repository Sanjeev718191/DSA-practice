public class leetcode787 {
    // link - https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> grp = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            grp.add(new ArrayList<>());
        }
        for(int edge[] : flights) {
            grp.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{src, 0});
        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;
        while(k >= 0 && !que.isEmpty()) {
            int s = que.size();
            k--;
            while(s-- > 0) {
                int curr[] = que.poll();
                for(int nxt[] : grp.get(curr[0])) {
                    if(dis[nxt[0]] > curr[1]+nxt[1]) {
                        dis[nxt[0]] = curr[1]+nxt[1];
                        que.offer(new int[]{nxt[0], dis[nxt[0]]});
                    }
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE? -1: dis[dst];
    }
}