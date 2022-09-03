import java.util.*;
class MinStack {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack();
    /** initialize your data structure here. */
    public MinStack() {
               
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() ||  minStack.peek()>val ||minStack.peek()==val)
            minStack.push(val);
    }
    
    public void pop() {
        if(!stack.isEmpty() && !minStack.isEmpty()){
            if(stack.peek()>minStack.peek())
                stack.pop();
            else if(stack.peek().intValue() == minStack.peek().intValue()){
                stack.pop();
                minStack.pop();
             }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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
