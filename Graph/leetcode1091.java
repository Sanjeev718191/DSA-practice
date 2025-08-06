public class leetcode1091 {
    // link - https://leetcode.com/problems/shortest-path-in-binary-matrix/description/
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;
        int dir[][] = {{-1,-1}, {0,-1}, {-1,0}, {1,-1}, {-1,1}, {0,1}, {1,0}, {1,1}};
        while(!q.isEmpty()) {
            int curr[] = q.poll();
            if(curr[0] == n-1 && curr[1] == n-1) return curr[2];
            for(int d[] : dir) {
                int x = curr[0]+d[0];
                int y = curr[1]+d[1];
                if(x < 0 || y < 0 || x >= n || y >= n || grid[x][y] == 1) continue;
                q.offer(new int[]{x,y, curr[2]+1});
                grid[x][y] = 1;
            }
        }
        return -1;
    }
}