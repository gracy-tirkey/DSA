public class TilingProblem {

    // Method-I
    public static int tilingProblem(int n){ // 2 x n (floorSize)
        if( n==0 || n==1) return 1;
        // Vertical choice
        int verticalChoice = tilingProblem(n-1);
        int horizontalChoice = tilingProblem(n-2);
        return verticalChoice + horizontalChoice;
    }
    
    // Method-II
    public static int tilingProblem2(int n){ // 2 x n (floorSize)
        if( n==0 || n==1) return 1;
        return tilingProblem2(n-1) + tilingProblem2(n-2);
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(4));
    }
}
