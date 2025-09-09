class JavaBasics {

    public static void main(String args[]) {
        // System.out.println("Factorial: " + factorial(5));
        // System.out.println("Binomial Coefficient " + binomialCoefficient(5, 3));

        // hollowRectangle(4, 5);
        // zeroOneTriangle(5);

        // printPrime(1, 100);

        fibonacciSeries(13);
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int binomialCoefficient(int n, int r) {
        int numerator = factorial(n);
        int denominator = factorial(r) * factorial(n - r);
        int result = numerator / denominator;
        return result;
    }

    public static void fibonacciSeries(int n) {
        int n1=0, n2=1, n3;
        while(n!=0){
            System.out.print(n1+" ");
            n3=n1+n2;
            n2=n1;
            n1=n3;
            n--;
        }
    }

    public static boolean isPrime(int n) {
        boolean isPrime = true;
        if (n == 2) return true;
        if (n == 4) return false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void printPrime(int x, int y) {
        for (int i = x; i <= y; i++) {
            if(isPrime(i)){
                System.out.print(i+" ");
            }
        }
    }


    public static void hollowRectangle(int n, int m) {
        System.out.println("\n hollow Rectangle ("+n+" x "+m+")");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 || i == n || j == 1 || j == m) {
                    System.out.print(" *");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n) {
        System.out.println("\n 0-1 Triangle ("+n+")");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(" 1");
                }else{
                    System.out.print(" 0");
                }
            }
            System.out.println();
        }
    }
}