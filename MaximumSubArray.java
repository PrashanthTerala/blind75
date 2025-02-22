public class MaximumSubArray {

    public static void main(String[] args) {
        int[] numbers = {-2,1};
        int maxSum = maxSubArray(numbers);
        System.out.println(maxSum);
    }

    public static int maxSubArray(int[] nums) {
        int i = 0, maxSum = nums[0], sum = 0;
        while(i < nums.length) {
            if(sum < 0) {
                sum = 0;
            }
            sum = sum + nums[i];
            maxSum = Math.max(maxSum, sum);
            i++;
        }
        return maxSum;
    }
}
