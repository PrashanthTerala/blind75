public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] numbers = {3,4,5,1,2};
        int minimum = findMin(numbers);
        System.out.println(minimum);
    }

    private static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (right == left)
                return nums[mid];
            if (nums[left] < nums[right]) {
                if (nums[mid] > nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[right] > nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
