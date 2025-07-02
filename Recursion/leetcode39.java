public class leetcode39 {
    // link - https://leetcode.com/problems/combination-sum/description/
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        targetSum(candidates, 0, target, new ArrayList<>());
        return res;
    }
    private void targetSum(int nums[], int ind, int target, List<Integer> ls) {
        if(target == 0) {
            res.add(new ArrayList<>(ls));
            return;
        }
        if(target < 0 || ind >= nums.length) return;
        targetSum(nums, ind+1, target, ls);
        ls.add(nums[ind]);
        targetSum(nums, ind, target-nums[ind], ls);
        ls.remove(ls.size()-1);
    }
}
