import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temps = {30,38,30,36,35,40,28};
        int[] diff = dailyTemperatures(temps);
        System.out.println(Arrays.toString(diff));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] differences = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int topI = stack.pop();
                int diff = i - topI;
                differences[topI] = diff;
            }
            stack.add(i);
        }
        while(!stack.isEmpty()) {
            differences[stack.pop()] = 0;
        }
        return differences;
    }
}
