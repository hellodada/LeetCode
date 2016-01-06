class MinStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    public void push(int x) {
        s.push(x);
        if(min.empty() || x <= min.peek())
            min.push(x);
        
    }

    public void pop() {
        if((int)s.peek() ==(int) min.peek())
            min.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
        
    }

    public int getMin() {
        return min.peek();
        
    }
}