public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] numbers = {3,1};
        int target = 1;
        int position = search(numbers, target);
        System.out.println(position);
    }

    private static int search(int[] nums, int target) {
        // 4,5,6,7,0,1,2 target = 0
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                if(nums[left] <= target && nums[mid] >= target)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if(nums[right] >= target && nums[mid] <= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
