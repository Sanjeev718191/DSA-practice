public class TopViewBTree {
    // link - https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
}

class pair{
    int i;
    Node node;
    pair(int i, Node curr){
        this.i = i;
        node = curr;
    }
}
class Solution {
    static ArrayList<Integer> topView(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, root));
        while(!q.isEmpty()){
            pair curr = q.poll();
            if(!map.containsKey(curr.i)) map.put(curr.i, curr.node.data);
            if(curr.node.left != null) q.add(new pair(curr.i-1, curr.node.left));
            if(curr.node.right != null) q.add(new pair(curr.i+1, curr.node.right));
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()) res.add(e.getValue());
        return res;
    }
}