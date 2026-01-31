public class SQ03_ImplementStackusingQueue {
    // https://leetcode.com/problems/implement-queue-using-stacks/
}

class MyQueue {
    Stack<Integer> st;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()) {
            temp.push(st.pop());
        }
        int poped = temp.pop();
        while(!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return poped;
    }
    
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while(!st.isEmpty()) {
            temp.push(st.pop());
        }
        int top = temp.peek();
        while(!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return top;
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}