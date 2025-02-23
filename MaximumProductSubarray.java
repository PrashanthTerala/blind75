public class MaximumProductSubarray {

    /*
    * Input: nums = [2,3,-2,4]
    * Output: 6
    * Explanation: [2,3] has the largest product 6.
    *
    * Solution: Calculate prefix product and suffix product and take max
    * */
    public static void main(String[] args) {
        int[] numbers = {-2,0,-1};
        int product = maxProduct(numbers);
        System.out.println(product);
    }

    public static int maxProduct(int[] nums) {
        int pre = 1, suf = 1, maximumProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (pre == 0)
                pre = 1;
            if (suf == 0)
                suf = 1;
            pre = pre * nums[i];
            suf = suf * nums[nums.length - i - 1];
            maximumProduct = Math.max(maximumProduct, Math.max(pre, suf));
        }
        return maximumProduct;
    }
}
