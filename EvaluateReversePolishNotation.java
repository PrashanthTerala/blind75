import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens = {"1","2","+","3","*","4","-"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String str: tokens) {
                if(str.equals("+")) {
                    stack.add(stack.pop() + stack.pop());
                } else if(str.equals("-")){
//                    int a = stack.pop();
//                    int b = stack.pop();
                    stack.add(-stack.pop() + stack.pop());
                } else if(str.equals("*")){
                    stack.add(stack.pop()*stack.pop());
                } else if(str.equals("/")){
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.add(b/a);
                } else {
                    stack.add(Integer.valueOf(str));
            }
        }
        return stack.pop();
     }
}
