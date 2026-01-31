public class SQ08_ImplementMinStack {
    // https://leetcode.com/problems/min-stack/description/
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

class MinStack {
    class Node {
        Node next;
        int val, min;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if(head == null) head = new Node(val, val, null);
        else head = new Node(val, Math.min(val, head.min), head);
    }
    
    public void pop() {
        if(head == null) return;
        head = head.next;
    }
    
    public int top() {
        if(head == null) return -1;
        return head.val;
    }
    
    public int getMin() {
        if(head == null) return -1;
        return head.min;
    }
}