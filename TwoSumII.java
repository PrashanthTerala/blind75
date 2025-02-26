import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4}; int target = 3;
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
    }
    private static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            if(numbers[i] + numbers[j] == target)
                return new int[] {i+1, j+1};
            while (numbers[i] + numbers[j] > target) {
                j--;
            }
            while(numbers[i] + numbers[j] < target) {
                i++;
            }
        }
        return new int[]{};
    }
}
