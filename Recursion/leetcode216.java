public class leetcode216 {
    // link - https://leetcode.com/problems/combination-sum-iii/description/
}

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        generate(k, n, 1, new ArrayList<>());
        return res;
    }
    private void generate(int k, int n, int curr, List<Integer> ls) {
        if(n == 0) {
            if(k == 0) res.add(new ArrayList<>(ls));
            return;
        }
        if(curr > 9) return;
        generate(k, n, curr+1, ls);
        if(n >= curr) {
            ls.add(curr);
            generate(k-1, n-curr, curr+1, ls);
            ls.remove(ls.size()-1);
        }
    }
}
