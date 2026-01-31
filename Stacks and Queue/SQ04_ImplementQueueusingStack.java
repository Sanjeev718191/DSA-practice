public class SQ04_ImplementQueueusingStack {
    // https://leetcode.com/problems/implement-stack-using-queues/description/
}

class MyStack {
    Queue<Integer> que;
    int top;
    public MyStack() {
        que = new LinkedList<>();
        top = -1;
    }
    
    public void push(int x) {
        que.offer(x);
        top = x;
    }
    
    public int pop() {
        int size = que.size();
        while(size > 1) {
            top = que.poll();
            que.offer(top);
            size--;
        }
        return que.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}