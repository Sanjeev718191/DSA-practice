public class leetcode547 {
    // link - https://leetcode.com/problems/number-of-provinces/description/
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean vis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i]) {
                dfs(isConnected, i, vis);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] isConnected, int ind, boolean vis[]) {
        if(vis[ind]) return;
        vis[ind] = true;
        for(int nxt = 0; nxt<isConnected.length; nxt++) {
            if(isConnected[ind][nxt] == 0) continue;
            dfs(isConnected, nxt, vis);
        }
    }
}