public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        int minimum = findMin(numbers);
        System.out.println(minimum);
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[left] <= nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else {
                min = Math.min(min, nums[right]);
                right = mid - 1;
            }
        }
        return min;
    }
}
