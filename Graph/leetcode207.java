public class leetcode207 {
    // link - https://leetcode.com/problems/course-schedule/description/
}

class Solution {
    ArrayList<Integer> res;
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> grp = new ArrayList<>();
        for(int i = 0; i<n; i++) grp.add(new ArrayList<>());
        int inDeg[] = new int[n];
        for(int curr[] : prereq) {
            inDeg[curr[0]]++;
            grp.get(curr[1]).add(curr[0]);
        }
        this.res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        for(int i = 0; i<n; i++) {
            if(!vis[i] && inDeg[i] == 0) {
                if(dfs(grp, i, vis, pathVis, inDeg)) return false;
            } 
        }
        if(res.size() != n) return false;
        return true;
    }
    private boolean dfs(List<List<Integer>> grp, int curr, boolean vis[], boolean pathVis[], int inDeg[]) {
        if(pathVis[curr]) return true;
        if(vis[curr]) return false;
        vis[curr] = true;
        pathVis[curr] = true;
        this.res.add(curr);
        for(int nxt : grp.get(curr)) {
            inDeg[nxt]--;
            if(inDeg[nxt] == 0 && dfs(grp, nxt, vis, pathVis, inDeg)) return true;
        }
        pathVis[curr] = false;
        return false;
    }
}