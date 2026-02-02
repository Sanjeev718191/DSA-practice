public class SQ12_PostfixToPrefixConversion {
    // https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1
}

class Solution {
    static String postToPre(String post_exp) {
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
                st.push(c + exp2 + exp1);
            }
        }
        return st.pop();
    }
}