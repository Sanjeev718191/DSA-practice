public class leetcode282 {
    // link - https://leetcode.com/problems/expression-add-operators/description/
}

class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        String s = "";
        int v = 0;
        for(int i = 0; i<num.length(); i++) {
            s += num.charAt(i);
            v = v*10 + (num.charAt(i)-'0');
            addOperators(num, target, i+1, s, v);
        }
        return res;
    }
    private void addOperators(String num, int target, int ind, String curr, int val) {
        if(target == val) {
            if(ind == num.length()) res.add(curr);
            return;
        }
        if(ind == num.length() || val > target) return;
        String s = "";
        int v = 0;
        for(int i = ind; i<num.length(); i++) {
            s += num.charAt(i);
            v = v*10 + (int)(num.charAt(i)-'0');
            addOperators(num, target, i+1, curr+'+'+s, val+v);
            addOperators(num, target, i+1, curr+'-'+s, val-v);
            addOperators(num, target, i+1, curr+'*'+s, val*v);
        }
    }
}
