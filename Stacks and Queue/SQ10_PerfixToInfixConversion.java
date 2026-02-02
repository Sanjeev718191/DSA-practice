public class SQ10_PerfixToInfixConversion {
    // https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1
}

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        StringBuilder res = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i = pre_exp.length()-1; i>=0; i--) {
            char c = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                st.push(c+"");
            } else {
                st.push("(" + st.pop() + c + st.pop() + ")");
            }
        }
        return st.pop();
    }
}