public class FloydWarshalAlgo {
    // link - https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
}

class Solution {
    public void floydWarshall(int[][] dis) {
        int n = dis.length;
        int infinite = (int)1e8;
        
        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(dis[i][k] == infinite || dis[k][j] == infinite) continue;
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        
    }
}