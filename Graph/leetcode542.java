public class leetcode542 {
    // link - https://leetcode.com/problems/01-matrix/description/
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int dis[][] = new int[m][n];
        int dir[][] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(mat[i][j] == 0) {
                    for(int d[] : dir) {
                        int x = i+d[0];
                        int y = j+d[1];
                        if(x<0 || y<0 || x>=m || y>=n || mat[x][y] == 0) continue;
                        que.offer(new int[]{x,y});
                    }
                } 
            }
        }
        int distance = 1;
        while(!que.isEmpty()) {
            int s = que.size();
            for(int i = 0; i<s; i++) {
                int curr[] = que.poll();
                if(dis[curr[0]][curr[1]] != 0) continue;
                dis[curr[0]][curr[1]] = distance;
                for(int d[] : dir) {
                    int x = curr[0]+d[0];
                    int y = curr[1]+d[1];
                    if(x<0 || y<0 || x>=m || y>=n || mat[x][y] == 0 || dis[x][y] != 0) continue;
                    que.offer(new int[]{x,y});
                }
            }
            distance++;
        }
        return dis;
    }
}