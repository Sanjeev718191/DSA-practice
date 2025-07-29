public class leecode126 {
    // link - https://leetcode.com/problems/word-ladder-ii/description/
}

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Queue<List<String>> que = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        ls.add(beginWord);
        hs.add(beginWord);
        que.offer(new ArrayList<>(ls));

        while(!que.isEmpty()) {
            int size = que.size();
            boolean flag = false;
            Set<String> levelVis = new HashSet<>();
            for(int i = 0; i<size; i++) {
                ls = que.poll();
                String curr = ls.get(ls.size()-1);
                if(curr.equals(endWord)) {
                    flag = true;
                    res.add(new ArrayList<>(ls));
                }
                for(String word : wordList) {
                    if(!ls.contains(word) && !hs.contains(word) && getDiff(curr, word) == 1) {
                        ls.add(word);
                        que.offer(new ArrayList<>(ls));
                        ls.remove(ls.size()-1);
                        levelVis.add(word);
                    }
                }
            }
            if(flag) break;
            for(String s : levelVis) hs.add(s);
        }
        return res;
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