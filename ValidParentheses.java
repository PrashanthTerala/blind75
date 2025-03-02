import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String input = "(){}[]";
        System.out.println(isValid(input));
    }
    //[ ({[ ]
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeOpen = Map.of(')','(','}','{',']','[');
        for(int i = 0; i < s.length(); i++) {
            if(closeOpen.containsKey(s.charAt(i))) {
                if(!stack.isEmpty() && closeOpen.get(s.charAt(i)) == stack.peek())
                    stack.pop();
                else
                    return false;
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
