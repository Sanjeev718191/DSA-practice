public class SQ11_PrefixToPostfixConversion {
    // https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1
}

class Solution {
    static String preToPost(String pre_exp) {
        return infixToPostfix(preToInfix(pre_exp));
    }
    static String preToInfix(String pre_exp) {
        String res = "";
        Stack<String> st = new Stack<>();
        for(int i = pre_exp.length()-1; i>=0; i--) {
            char c = pre_exp.charAt(i);
            // System.out.println(c + " -> " + st);
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') 
                st.push(c+"");
            else {
                String curr = '(' + st.pop() + c + st.pop() + ')';
                st.push(curr);
            }
        }
        return st.pop();
    }
    public static String infixToPostfix(String s) {
        String res = "";
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') res += c;
            else {
                if(c == '+' || c == '-') {
                    while(!st.isEmpty() && st.peek() != '(') {
                        res += st.pop();
                    }
                    st.push(c);
                } else if(c == '(') {
                    st.push(c);
                } else if(c == ')') {
                    while(!st.isEmpty() && st.peek() != '(') {
                        res += st.pop();
                    }
                    st.pop();
                } else if(c == '*' || c == '/') {
                    while(!st.isEmpty() && st.peek() != '(' && (st.peek() == '*' || st.peek() == '/' || st.peek() == '^'))
                        res += st.pop();
                    st.push(c);
                } else {
                    while(!st.isEmpty() && st.peek() != '(' && st.peek() == '^')
                        res += st.pop();
                    st.push(c);
                }
            }
        }
        while(!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        StringBuilder res = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i = pre_exp.length()-1; i>=0; i--) {
            char c = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(c+"");
            } else {
                st.push(st.pop() + st.pop() + c);
            }
        }
        return st.pop();
    }
}