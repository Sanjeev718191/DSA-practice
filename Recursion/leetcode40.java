public class leetcode40 {
    // link - https://leetcode.com/problems/combination-sum-ii/description/
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        generate(candidates, 0, target, new ArrayList<>());
        return res;
    }
    private void generate(int can[], int ind, int t, List<Integer> ls) {
        if(t == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        if(ind >= can.length || t < 0) return;
        for(int i = ind; i<can.length; i++) {
            if(i == ind || can[i-1] != can[i]) {
                ls.add(can[i]);
                generate(can, i+1, t-can[i], ls);
                ls.remove(ls.size()-1);
            }
        }
    }
}
