public class leetcode139 {
    // link - https://leetcode.com/problems/word-break/description/
}

class Solution {
    HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return wordBreakUtil(s, wordDict);
    }
    private boolean wordBreakUtil(String s, List<String> wordDict) {
        if(map.containsKey(s)) return map.get(s);
        for(String word : wordDict) {
            if(s.indexOf(word) == 0 ) {
                if(s.length() == word.length() || 
                    wordBreakUtil(s.substring(word.length(), s.length()), wordDict)) {
                        map.put(s, true);
                        return true;
                    }
            }
        }
        map.put(s, false);
        return false;
    }
}
