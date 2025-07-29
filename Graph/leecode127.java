public class leecode127 {
    // link - https://leetcode.com/problems/word-ladder/description/
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> que = new LinkedList<>();
        Set<String> hs = new HashSet<>();
        que.offer(beginWord);
        hs.add(beginWord);
        int count = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            count++;
            for(int i = 0; i<size; i++) {
                String curr = que.poll();
                if(curr.equals(endWord)) return count;
                for(String word : wordList) {
                    if(!hs.contains(word) && getDiff(curr, word) == 1) {
                        que.offer(word);
                        hs.add(word);
                    }
                }
            }
        }
        return 0;
    }
    private int getDiff(String s1, String s2){
        int count = 0;
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count;
    }
}