public class leetcode733 {
    // link - https://leetcode.com/problems/flood-fill/description/
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int n = image.length;
        int m = image[0].length;
        int src = image[sr][sc];
        boolean vis[][] = new boolean[n][m];
        dfs(sr, sc, newColor, image, vis, src);
        return image;
    }
    private void dfs(int sr, int sc, int newColor, int[][] image, boolean vis[][], int src){
        int n = image.length;
        int m = image[0].length;
        if(sr<0 || sc<0 || sr>=n || sc>=m || image[sr][sc] != src || vis[sr][sc])
            return;
        image[sr][sc] = newColor;
        vis[sr][sc] = true;
        dfs(sr-1, sc, newColor, image, vis, src);
        dfs(sr+1, sc, newColor, image, vis, src);
        dfs(sr, sc-1, newColor, image, vis, src);
        dfs(sr, sc+1, newColor, image, vis, src);
    }
}