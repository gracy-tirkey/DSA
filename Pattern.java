public class Pattern {
    public static void main(String[] args) {
        buildPyramid(7);
        revPyramid(7);
        buildX(7);
    }

    public static void buildPyramid(int rows) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 2 * rows; j++) {
                if (j >= rows - i && j < rows + i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void revPyramid(int rows) {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < 2 * rows; j++) {
                if (j < rows - i) {
                    System.out.print((char) (65 + j));
                } else if (j >= rows + i) {
                    System.out.print((char) (78 - j));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

        public static void buildX(int rows) {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if ((i==j) && (i+j == rows-1)) {
                    System.out.print("X ");
                } else if ((i==j) || (i+j == rows-1)) {
                    System.out.print("1 ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

}
