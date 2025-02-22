import java.util.*;

public class TwoSum {

    /*
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15}; int target = 9;
//        int[] numbers = {3,2,4}; int target = 6;
//        int[] numbers = {3,3}; int target = 6;
//        int[] numbers = {3,3}; int target = 100;
        int[] twoSumArray = twoSum(numbers, target);
        System.out.println(Arrays.toString(twoSumArray));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if(visited.containsKey(remaining))
                return new int[] {visited.get(remaining), i};
            visited.put(nums[i], i);
        }
        return new int[]{};
    }
}
