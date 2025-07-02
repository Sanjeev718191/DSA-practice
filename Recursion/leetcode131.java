public class leetcode131 {
    // link - https://leetcode.com/problems/palindrome-partitioning/description/
}

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        partition(s, 0, new ArrayList<>());
        return result;
    }
    private void partition(String s, int ind, List<String> list) {
        if(ind >= s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        String curr = "";
        for(int i = ind; i<s.length(); i++) {
            curr += s.charAt(i);
            if(checkPalindrome(curr)) {
                list.add(curr);
                partition(s, i+1, list);
                list.remove(list.size()-1);
            }
        }
    }
    private boolean checkPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
