public class TrappingRainWater {

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int water = trap(heights);
        System.out.println(water);
    }

    private static int trap(int[] height) {
        int collectedWater = 0;
        int left = 0;
        int leftMaxHeight = height[left];

        int right = height.length - 1;
        int rightMaxHeight = height[right];

        while (left < right) {
            if (leftMaxHeight < rightMaxHeight) {
                left++;
                leftMaxHeight = Math.max(leftMaxHeight, height[left]);
                collectedWater += leftMaxHeight - height[left];
            } else {
                right--;
                rightMaxHeight = Math.max(rightMaxHeight, height[right]);
                collectedWater += rightMaxHeight - height[right];
            }
        }
        return collectedWater;
    }
}
