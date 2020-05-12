import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int x) {
        if(min>x)
            min=x;
        stack.push(x);
    }

    public void pop() {
        if(stack.pop()==min){
            min=Integer.MAX_VALUE;
            for(Integer val:stack.toArray(new Integer[0])){
                if(min<val)
                    min=val;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
