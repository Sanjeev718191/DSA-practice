public class leetcode863 {
    // link - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
}

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer, TreeNode> par = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                par.put(curr.left.val, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                par.put(curr.right.val, curr);
                q.offer(curr.right);
            }
        }
        HashSet<Integer> vis = new HashSet<>();
        q.offer(target);
        while(!q.isEmpty() && k > 0){
            int s = q.size();
            while(s-- > 0){
                TreeNode curr = q.poll();
                vis.add(curr.val);
                if(curr.left != null && !vis.contains(curr.left.val)){
                    q.offer(curr.left);
                }
                if(curr.right != null && !vis.contains(curr.right.val)){
                    q.offer(curr.right);
                }
                if(par.containsKey(curr.val) && !vis.contains(par.get(curr.val).val)){
                    q.offer(par.get(curr.val));
                }
            }
            k--;
        }
        List<Integer> ls = new ArrayList<>();
        while(!q.isEmpty()) ls.add(q.poll().val);
        return ls;
    }
}