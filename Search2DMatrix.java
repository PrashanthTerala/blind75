public class Search2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7}, // row 1
                {10, 11, 16, 20}, // row 2
                {23, 30, 34, 60} // row 3
        };
        int target = 60;
        boolean isFound = searchMatrix(matrix, target);
        System.out.println(isFound);
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1; // m*n-1
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }
}
