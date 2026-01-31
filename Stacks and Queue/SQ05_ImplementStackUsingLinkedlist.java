public class SQ05_ImplementStackUsingLinkedlist {
    // https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
}

class myStack {
    Node head;
    int size;
    
    public myStack() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        Node nxt = new Node(x);
        nxt.next = head;
        head = nxt;
        size++;
    }

    public void pop() {
        if(head == null) return;
        size--;
        head = head.next;
    }

    public int peek() {
        if(head == null) return -1;
        int val = head.data;
        return val;
    }

    public int size() {
        return size;
    }
}
