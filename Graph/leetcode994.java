public class leetcode994 {
    // link - https://leetcode.com/problems/rotting-oranges/description/
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> que = new LinkedList<>();

        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        int count = 0;
        int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!que.isEmpty()) {
            int size = que.size();
            count++;
            for(int i = 0; i<size; i++) {
                int curr[] = que.poll();
                for(int d[] : dir) {
                    int p = curr[0]+d[0];
                    int q = curr[1]+d[1];
                    if(p<0 || q<0 || p>=m || q>=n || vis[p][q] || grid[p][q] != 1) continue;
                    grid[p][q] = 2;
                    vis[p][q] = true;
                    que.offer(new int[]{p, q});
                }
            }
        }
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        if(count != 0) count--;
        return count;
    }
}