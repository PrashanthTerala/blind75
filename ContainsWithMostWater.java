public class ContainsWithMostWater {

    public static void main(String[] args) {
        int[] heights = {1,1};
        int mostWater = maxArea(heights);
        System.out.println(mostWater);
    }

    // 1,8,6,2,5,4,8,3,7
    //   ^
    //                 ^
    private static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, mostWater = 0, maxHeight = 0;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int length = j - i;
            mostWater = Math.max(mostWater, (length * minHeight));
            while (i < j && height[i] <= minHeight)
                i++;
            while (i < j && height[j] <= minHeight)
                j--;
        }
        return mostWater;
    }
}
