public class SQ07_CheckForBalancedParanthesis {
    // https://leetcode.com/problems/valid-parentheses/description/
}

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 == 1)
            return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else if(c == ')'){
                if(st.size()>0 && st.peek() == '(')
                    st.pop();
                else
                    return false;
            } else if(c == ']'){
                if(st.size()>0 && st.peek() == '[')
                    st.pop();
                else
                    return false;
            } else if(c == '}'){
                if(st.size()>0 && st.peek() == '{')
                    st.pop();
                else
                    return false;
            }
        }
        if(st.size() > 0)
            return false;
        return true;
    }
}