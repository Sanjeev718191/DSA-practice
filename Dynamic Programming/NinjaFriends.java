public class NinjaFriends {
    // link - https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13/
}

public class Solution {
	static Integer dp[][][];
	public static int maximumChocolates(int r, int c, int[][] grid) {
		dp = new Integer[r][c][c];
		return maxCount(grid, 0, 0, c-1);
	}
	public static int maxCount(int grid[][], int i, int j1, int j2) {
		if(j1<0 || j2<0 || j1>=grid[0].length || j2>=grid[0].length) return Integer.MIN_VALUE;
		if(i == grid.length-1) {
			if(j1 == j2) return grid[i][j1];
			return grid[i][j1] + grid[i][j2];
		}
		if(dp[i][j1][j2] != null) return dp[i][j1][j2];
		int max = Integer.MIN_VALUE;
		for(int x = -1; x<=1; x++) {
			for(int y = -1; y<=1; y++) {
				if(j1 == j2) {
					max = Math.max(max, maxCount(grid, i+1, j1+x, j2+y)+grid[i][j1]);
				} else {
					max = Math.max(max, maxCount(grid, i+1, j1+x, j2+y)+grid[i][j1]+grid[i][j2]);
				}
			}
		}
		return dp[i][j1][j2] = max;
	}
}
