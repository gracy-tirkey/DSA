public class TilingProblem {

    public static int tilingProblem(int n){ // 2 x n (floorSize)
        if( n==0 || n==1) return 1;
        // Vertical choice
        int verticalChoice = tilingProblem(n-1);
        int horizontalChoice = tilingProblem(n-2);
        return verticalChoice + horizontalChoice;
    }

    public static void main(String[] args) {
        System.out.println(tilingProblem(4));
    }
}
