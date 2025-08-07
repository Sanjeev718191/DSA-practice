public class MinimumMultiplicationsReachEnd {
    // link - https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{start, 0});
        
        int mod = (int)1e5;
        int dis[] = new int[mod+1];
        Arrays.fill(dis, (int)1e9);
        dis[start] = 0;
        
        while(!pq.isEmpty()) {
            int curr[] = pq.poll();
            for(int i : arr) {
                int nxt = (curr[0]*i)%mod;
                if(dis[nxt] > curr[1]+1) {
                    dis[nxt] = curr[1]+1;
                    pq.offer(new int[]{nxt, dis[nxt]});
                    if(nxt == end) return dis[nxt];
                }
            }
        }
        
        return -1;
    }
}
