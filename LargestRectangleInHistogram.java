import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
//        int[] heights = {1,3,7};
        int maxArea = largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    private static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
