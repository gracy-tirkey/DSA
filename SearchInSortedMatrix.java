public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        System.out.println(staircaseSearch(matrix, 15));
        System.out.println(staircaseSearch2(matrix, 15));
    }

    // Method-I
    public static boolean staircaseSearch2(int matrix[][], int key){
        int row = matrix.length-1, col = 0;

        while(row>=0 && col<matrix[0].length){
            if(matrix[row][col] == key){
                System.out.println("Found Key at ("+row+","+col+")");
                return true;
            }else if(matrix[row][col] > key){
                row--;
            }
            else{
                col++;
            }
        }
        System.out.println("Key Not Found!!");
        return false;
    }

    // Method-II
    public static boolean staircaseSearch(int matrix[][], int key){
        int row = 0, col = matrix[0].length-1;

        while(row<matrix.length && col>=0){
            if(matrix[row][col] == key){
                System.out.println("Found Key at ("+row+","+col+")");
                return true;
            }else if(matrix[row][col] > key){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("Key Not Found!!");
        return false;
    }
}
