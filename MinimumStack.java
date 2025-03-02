import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
        } else {
            if(minStack.peek() >= val) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
            stack.push(val);
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class MinimumStack {
    public static void main(String[] args) {
        //  "push", 5, "push", 0, "push", 2, "push", 4, "getMin", "pop", "getMin", "pop", "getMin"
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(0);
        minStack.push(2);
        minStack.push(4);
        System.out.println(minStack.getMin()); // -3
        minStack.pop(); // -3
        System.out.println(minStack.getMin());
        minStack.pop(); //-2
        System.out.println(minStack.getMin()); // -2
//
//        MinStack minStack = new MinStack();
//        minStack.push(1);
//        minStack.push(2);
//        minStack.push(0);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
    }
}

