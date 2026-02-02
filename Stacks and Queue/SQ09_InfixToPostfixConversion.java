public class SQ09_InfixToPostfixConversion {
    // https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1
}

class Solution {
    public static String infixToPostfix(String s) {
        // code here
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
            } else if(c == '^') {
                st.push(c);
            } else if(c == '*' || c == '/') {
                while(!st.isEmpty() && st.peek() != '(' && (st.peek() == '*' || st.peek() == '/' || st.peek() == '^')) {
                    res.append(st.pop());
                }
                st.push(c);
            } else if(c == '+' || c == '-') {
                while(!st.isEmpty() && st.peek() != '(') {
                    res.append(st.pop());
                }
                st.push(c);
            } else {
                res.append(c);
            }
        }
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
}

class Solution {
    public static int prec(char c) {
        if (c == '^') return 3;
        else if (c == '/' || c == '*') return 2;
        else if (c == '+' || c == '-') return 1;
        else return -1;
    }
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '^') {
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
                while(!st.isEmpty() && prec(c) <= prec(st.peek())) {
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