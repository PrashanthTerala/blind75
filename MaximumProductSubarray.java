public class MaximumProductSubarray {

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
