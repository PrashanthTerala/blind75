import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] result = nextGreaterElements(nums);
        System.out.println(Arrays.toString(result));

    }

    private static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> monotanicStack = new Stack<>();
        int[] map = new int[nums.length];
        Arrays.fill(map, -1);
        for(int i = 0; i < nums.length*2; i++) {
            while (!monotanicStack.isEmpty() && nums[monotanicStack.peek()] < nums[i % nums.length]) {
                int monoIndex = monotanicStack.pop();
                map[monoIndex] = nums[i % nums.length];
            }
            monotanicStack.push(i % nums.length);
        }
        return map;
    }
}
