import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        int[] nextGrater = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(nextGrater));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        Stack<Integer> monotanicStack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!monotanicStack.isEmpty() && nums2[monotanicStack.peek()] < nums2[i]) {
                int popIndex = monotanicStack.pop();
                map[nums2[popIndex]] = nums2[i];
            }
            monotanicStack.push(i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map[nums1[i]];
        }
        return result;
    }
}
