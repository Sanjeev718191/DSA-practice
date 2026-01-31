public class SQ02_ImplementQueueusingArrays {
    // https://www.geeksforgeeks.org/problems/implement-queue-using-array/1
}

class myQueue {
    
    int queArr[];
    int cap, start, end, size;
    
    // Constructor
    public myQueue(int n) {
        cap = n;
        queArr = new int[n];
        start = -1;
        end = -1;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    public void enqueue(int x) {
        if(!isFull()) {
            if(end == -1) start = 0;
            end = (end + 1)%cap;
            queArr[end] = x;
            size++;
        }
    }

    public void dequeue() {
        if(isEmpty()) return;
        size--;
        if(start == end) {
            start = -1;
            end = -1;
        }
        else start = (start + 1)%cap;
        
    }

    public int getFront() {
        if(!isEmpty()) return queArr[start];
        return -1;
    }

    public int getRear() {
        if(!isEmpty()) return queArr[end];
        return -1;
    }
}
