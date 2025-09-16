public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        // initialize
        char board[][] = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = 'x';
            }
        }
        nQueens(board, 0);
        System.out.println("No. of Solutions: "+countSolutions);
    }
    
    static int countSolutions = 0;

    public static void printBoard(char board[][]) {
        System.out.println("-------------chess board---------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void nQueens(char board[][], int row) {
        if (row == board.length) {
            printBoard(board);
            countSolutions++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // left-diagonal
        for (int i = row, j = col; i >=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // right-diagonal
        for (int i = row, j = col; i >= 0 && j<board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // vertical-up
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
