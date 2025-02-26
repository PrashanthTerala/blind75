public class ValidateSudoko {

    public static void main(String[] args) {
        char[][] matrix = new char[6][6];
        matrix[0][0] = '#'; matrix[0][1] = '#'; matrix[0][2] = '#'; matrix[0][3] = '1'; matrix[0][4] = '2'; matrix[0][5] = '3';
        matrix[1][0] = '#'; matrix[1][1] = '#'; matrix[1][2] = '#'; matrix[1][3] = '4'; matrix[1][4] = '5'; matrix[1][5] = '6';
        matrix[2][0] = '#'; matrix[2][1] = '#'; matrix[2][2] = '#'; matrix[2][3] = '7'; matrix[2][4] = '8'; matrix[2][5] = '9';
        // rows
        for(int i = 0; i < matrix.length; i++) {
            boolean[] rowArray = new boolean[10];
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '.')
                    continue;
                int num = matrix[i][j] - '0';
                if(rowArray[num])
                    System.out.println("not valid");
                rowArray[num] = true;
            }
        }
//         columns
        for(int i = 0; i < matrix.length; i++) {
            boolean[] col = new boolean[10];
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[j][i] == '.')
                    continue;
                int num = matrix[j][i] - '0';
                if(col[num])
                    System.out.println("not valid");
                col[num] = true;
            }
        }

        //box
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                grid(i * 3, j * 3, matrix);
            }
        }


    }
    private static void grid(int row, int col, char[][] board) {
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
