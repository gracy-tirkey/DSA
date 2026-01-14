
public class DPfibonacci {

    // Fibonacci sequence using Dynamic Programming
    public static int fibonacci(int n, int[] fib) {

        if( n == 0 || n == 1){
            return n;
        }
        if (fib[n] != 0) {
            return fib[n];
        }
        fib[n] = fibonacci(n - 1, fib) + fibonacci(n - 2, fib);
        return fib[n];
    }

    // Fibonacci sequence using Tabulation
    public static int fibonacciTabulation(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int n = 10; // Example input
        // Create an array to store Fibonacci numbers up to n
        int[] fib = new int[n + 1];
        System.out.println("Fibonacci number at position " + n + " is: " + fibonacci(n, fib));
    }
}