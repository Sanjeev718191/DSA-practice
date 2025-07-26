public class leecode85 {
    // link = https://leetcode.com/problems/maximal-rectangle/description/
}

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col[] = new int[n];
        int height = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(matrix[i][j] == '0') col[j] = 0;
                else col[j] = col[j]+1;
            }
            height = Math.max(height, maxHeight(col));
        }
        return height;
    }
    private int maxHeight(int nums[]) {
        int n = nums.length;
        int height = 0;
        for(int i = 0; i<n; i++) {
            int min = nums[i];
            for(int j = i; j<n && min != 0; j++) {
                min = Math.min(min, nums[j]);
                height = Math.max(height, (j-i+1)*min);
            }
        }
        return height;
    }
}