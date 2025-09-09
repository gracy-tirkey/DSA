public class DiagonalSum {
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println(diagonalSum(matrix));
        System.out.println(diagonalSum2(matrix));
    }

    // Method-I
    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i == j) sum+=matrix[i][j];
                if(i+j == matrix.length-1) sum+=matrix[i][j];
            }
        }
        return sum;
    }

    // Method-II
    public static int diagonalSum2(int matrix[][]){
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
                sum+=matrix[i][i];
                if(i != matrix.length-1-i) sum+=matrix[i][matrix.length-i-1];
            }
        
        return sum;
    }

}
