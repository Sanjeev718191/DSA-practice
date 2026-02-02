public class SQ14_InfixToPrefixConversion {
    // https://www.geeksforgeeks.org/problems/infix-to-prefix-notation/1
}

class Solution {
    public static int prec(char c) {
        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }
    public String infixToPrefix(String s) {
        // code here
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i) == '(') str.setCharAt(i, ')');
            else if(str.charAt(i) == ')') str.setCharAt(i, '(');
        }
        String postfix = infixToPostfix(str.toString());
        return new StringBuilder(postfix).reverse().toString();
    }
    public static String infixToPostfix(String s) {
        // code here
        s = "(" + s + ")";
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                st.push(c);
            } else if(c == ')') {
                while(!st.isEmpty()) {
                    char x = st.pop();
                    if(x == '(') break;
                    res.append(x);
                }
            } else if(Character.isLetterOrDigit(c)) {
                res.append(c);
            } else {
                while(!st.isEmpty() && (prec(c) < prec(st.peek()) || (prec(c) == prec(st.peek()) && c == '^'))) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
}