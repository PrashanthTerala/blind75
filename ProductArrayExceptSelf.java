public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] numbers = {0, 2, 1, 4};
        int[] products = productExceptSelf(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " : "+products[i]);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int pre = 1, post = 1;
        int[] product = new int[nums.length];
        product[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            product[i] = pre * nums[i - 1];
            pre = product[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            product[i] = product[i] * post;
            post = post * nums[i];
        }
        return product;
    }

}
