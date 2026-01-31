public class SQ01_ImplementStackusingArrays {
    // https://www.geeksforgeeks.org/problems/implement-stack-using-array/1
}

class myStack {

    int cap;
    int stArr[];
    int peek;

    public myStack(int n) {
        this.cap = n;
        this.stArr = new int[n];
        this.peek = -1;
    }

    public boolean isEmpty() {
        return this.peek == -1;
    }

    public boolean isFull() {
        return this.peek == this.cap-1;
    }

    public void push(int x) {
        if(this.peek < this.cap-1) {
            this.peek++;
            this.stArr[this.peek] = x;
        }
    }

    public void pop() {
        if(!isEmpty()) this.peek--;
    }

    public int peek() {
        if(!isEmpty()) return this.stArr[this.peek];
        return -1;
    }
}