class MinStack {
    Stack<Long> stack;
    long minVal;
    public MinStack() {
        stack = new Stack<>();
        minVal = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        long val = value;
        if(stack.isEmpty()){
            stack.push(val);
            minVal = val;
        }
        else {
            if(val <= minVal){
                stack.push(2 * val - minVal);
                minVal = val;
            }
            else {
                stack.push(val);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long val = stack.pop();
        if(val <= minVal){
            minVal = 2 * minVal - val;
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        long val = stack.peek();
        if(val <= minVal) return (int) minVal;
        return (int) val;
    }
    
    public int getMin() {
        return (int) minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */