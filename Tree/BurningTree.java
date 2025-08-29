public class BurningTree {
    // link - https://www.geeksforgeeks.org/problems/burning-tree/1
}

class Solution {
    public static int minTime(Node root, int target) {
        HashMap<Integer, Node> par = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node targetNode = null;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data == target) targetNode = curr;
            if(curr.left != null){
                par.put(curr.left.data, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                par.put(curr.right.data, curr);
                q.offer(curr.right);
            }
        }
        HashSet<Integer> vis = new HashSet<>();
        q.offer(targetNode);
        int count = 0;
        while(!q.isEmpty()){
            int s = q.size();
            while(s-- > 0){
                Node curr = q.poll();
                vis.add(curr.data);
                if(curr.left != null && !vis.contains(curr.left.data)){
                    q.offer(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right.data)){
                    q.offer(curr.right);
                }
                if(par.containsKey(curr.data) && !vis.contains(par.get(curr.data).data)){
                    q.offer(par.get(curr.data));
                }
            }
            count++;
        }
        return count-1;
    }
}