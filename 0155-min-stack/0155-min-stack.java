class MinStack {

    Stack<Integer> stack;
    int min = Integer.MAX_VALUE;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        min = Math.min(val, min);
        map.put(val, map.getOrDefault(val,0)+1);
    }
    
    public void pop() {
        int val = stack.pop();
        if(min==val && map.get(val)==1){
            min = Integer.MAX_VALUE;
            for(int i: stack){
                min=Math.min(min, i);
            }
        }
        map.put(val, map.get(val)-1);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */