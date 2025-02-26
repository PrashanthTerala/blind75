import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {-5,-3,0,2,4,6,8}; int target = 5;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
    // -3,3,4,90 | target = 0
    //  ^
    //    ^
    private static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum > target)
                j--;
            else if(sum < target)
                i++;
            else
                return new int[] {i+1, j+1};
        }
        return new int[]{};
    }
}
