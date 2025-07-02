public class leetcode78 {
    // link - https://leetcode.com/problems/subsets/description/
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        generate(nums, 0, new ArrayList<>());
        return res;
    }
    private void generate(int nums[], int ind, List<Integer> ls) {
        if(ind >= nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        generate(nums, ind+1, ls);
        ls.add(nums[ind]);
        generate(nums, ind+1, ls);
        ls.remove(ls.size()-1);
    }
}
