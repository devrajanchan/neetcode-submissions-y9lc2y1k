class MinStack {
    Stack<Integer> s;
    Stack<Integer> m;
    int min;
    public MinStack() {
        s= new Stack<>();
        m= new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        s.push(val);
        if(val<=min)
        {
            m.push(val);
            min=val;
        }
    }
    
    public void pop() {
        if(s.peek().equals(min))
        {
            m.pop();
            if(!m.isEmpty()) min=m.peek();
            else min=Integer.MAX_VALUE;
        }
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        if(m.isEmpty()) return 0;
         return m.peek();
    }
}
