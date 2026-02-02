public class SQ13_PostfixToInfixConversion {
    // https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1
}

class Solution {
    static String postToInfix(String post_exp) {
        // code here
        StringBuilder res = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i = 0; i<post_exp.length(); i++) {
            char c = post_exp.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(c+"");
            } else {
                String exp1 = st.pop();
                String exp2 = st.pop();
                st.push("(" + exp2 + c + exp1 + ")");
            }
        }
        return st.pop();
    }
}