public class leetcode22 {
    // link - https://leetcode.com/problems/generate-parentheses/description/
}

class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(n, "", 0, 0);
        return res;
    }
    private void generate(int n, String s, int o, int c) {
        if(o == c && o == n) {
            res.add(s);
            return;
        }
        if(o < n) {
            generate(n, s+'(', o+1, c);
        }
        if(c < o) {
            generate(n, s+')', o, c+1);
        }
    }
}