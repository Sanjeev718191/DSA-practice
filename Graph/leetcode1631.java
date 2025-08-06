public class leetcode1631 {
    // link - https://leetcode.com/problems/path-with-minimum-effort/description/
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        pq.offer(new int[]{0, 0, 0});

        int dis[][] = new int[m][n];
        for(int a[] : dis) Arrays.fill(a, Integer.MAX_VALUE);
        dis[0][0] = 0;

        int dir[][] = {{0,-1}, {-1,0}, {0,1}, {1,0}};

        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            if(curr[0] == m-1 && curr[1] == n-1) return curr[2];
            for(int d[] : dir) {
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];
                if(x < 0 || y < 0 || x >= m || y >= n) continue;
                int e = Math.max(curr[2], Math.abs(heights[curr[0]][curr[1]] - heights[x][y]));
                if(e >= dis[x][y]) continue;
                pq.offer(new int[]{x,y,e});
                dis[x][y] = Math.min(e, dis[x][y]);
            }
        }
        return -1;
    }
}