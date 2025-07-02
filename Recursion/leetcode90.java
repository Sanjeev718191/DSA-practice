public class leetcode90 {
    // link - https://leetcode.com/problems/subsets-ii/description/
}

class Solution {
    List<List<Integer>> ls;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ls = new ArrayList<>();
        getSubset(nums, 0, new ArrayList<>());
        return new ArrayList<>(ls);
    }
    private void getSubset(int nums[], int ind, List<Integer> curr) {
        ls.add(new ArrayList<>(curr));
        for(int i = ind; i<nums.length; i++) {
            if(i != ind && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            getSubset(nums, i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}
