class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList<Integer>();
        while(q.size() > 1)
            temp.add(q.remove());
        //q.remove();
        q = temp;
    }

    // Get the top element.
    public int top() {
        int i;
        Queue<Integer> temp = new LinkedList<Integer>(q);
        while(temp.size() > 1)
            temp.remove();
        i = temp.remove();
        return i;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0? true:false;
        
    }
}