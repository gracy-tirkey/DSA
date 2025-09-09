public class Digits {
    public static void main(String[] args) {
        // printDigits(2566);
        System.out.print("\n\n 21453: ");
        printInterchangedDigits(21453);// 23154
        
        System.out.print("\n\n 25686: ");
        printInterchangedDigits(25686);// 26586
    }

    public static int countDigits(int n) {
        int count = 0;

        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void printDigits(int n) {
        int count = countDigits(n) - 1, q, r;
        int divider = (int) Math.pow(10, count);
        while (divider != 0) {
            q = n / divider;
            System.out.print(q);
            r = n % divider;
            divider /= 10;
            n = r;
        }
    }

    public static void printInterchangedDigits(int n) {
        int count = countDigits(n) - 1, q, r;
        int divider = (int) Math.pow(10, count);
        
        while (divider != 0 ) {
            q = n / divider;
            System.out.print(q + " ");
            r = n % divider;
            divider/=10;
            if(divider == 0) break;
            System.out.print(r%10 + " ");
            divider /= 10;
            n = r / 10;
        }
    }
}
