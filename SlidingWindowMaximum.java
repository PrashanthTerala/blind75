import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] numbers = {7,2,4}; int k = 2;
//        int[] numbers = {1,-1}; int k = 1;
        int[] results = maxSlidingWindow(numbers, k);
        System.out.println(Arrays.toString(results));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) return new int[]{};
        int start = 0, end = 0;
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        while(end < nums.length) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[end]) {
                deque.removeLast();
            }
            deque.addLast(end);
            if(start > deque.getFirst()) {
                deque.removeFirst();
            }
            if ((end + 1) >= k) {
                output[start] = nums[deque.getFirst()];
                start++;
            }
            end++;
        }
        return output;
    }
}
