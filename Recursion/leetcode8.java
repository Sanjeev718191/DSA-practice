public class leetcode8 {

    // question link - https://leetcode.com/problems/string-to-integer-atoi/description/

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "42";
        System.out.println(myAtoi(s));
    }

}

class Solution {
    public int myAtoi(String s) {
        boolean positive = true;
        int i = 0;
        int n = s.length();
        if(n == 0) return 0;
        while(i<n && s.charAt(i) == ' '){ i++; }
        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            positive = (s.charAt(i) == '+') ? true: false;
            i++;
        }
        int res = 0;
        while(i<n){
            int c = s.charAt(i) - '0';
            if(c > 9 || c < 0){
                break;
            } else {
                if(res > Integer.MAX_VALUE/10 || res == Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10 < c)
                    return (positive)? Integer.MAX_VALUE : Integer.MIN_VALUE; 
                res = res*10 + c;
            } 
            i++;
        }
        if(!positive){
            res = -res;
        }
        return res; 
    }
}
