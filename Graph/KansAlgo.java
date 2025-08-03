public class KansAlgo {
    // link - https://www.geeksforgeeks.org/problems/topological-sort/1
}

class Solution {
    public static ArrayList<Integer> topoSort(int n, int[][] edges) {
        List<List<Integer>> grp = new ArrayList<>();
        for(int i = 0; i<n; i++) grp.add(new ArrayList<>());
        int inDeg[] = new int[n];
        for(int edge[] : edges) {
            inDeg[edge[1]]++;
            grp.get(edge[0]).add(edge[1]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            if(inDeg[i] == 0) {
                que.offer(i);
            } 
        }
        while(!que.isEmpty()) {
            int s = que.size();
            for(int i = 0; i<s; i++) {
                int curr = que.poll();
                res.add(curr);
                vis[curr] = true;
                for(int nxt : grp.get(curr)) {
                    if(vis[nxt]) continue;
                    inDeg[nxt]--;
                    if(inDeg[nxt] == 0) {
                        que.offer(nxt);
                    }
                }
            }
        }
        return res;
    }
}