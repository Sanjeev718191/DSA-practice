public class leetcode17 {
    // link - https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
}

class Solution {
    String num[] = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ls;
    public List<String> letterCombinations(String digits) {
        ls = new ArrayList<>();
        if(digits.length() != 0)
            generate(digits, 0, "");
        return ls;
    }
    private void generate(String digits, int ind, String s) {
        if(ind >= digits.length()) {
            ls.add(s);
            return;
        }
        String curr = num[(digits.charAt(ind)-'0')-1];
        for(char ch : curr.toCharArray()) {
            generate(digits, ind+1, s+ch);
        }
    }
}
