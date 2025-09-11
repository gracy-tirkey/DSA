public class NearestPrime {
    public static void main(String[] args) {
        nearestPrime(17);
    }
    
    public static void nearestPrime(int n){
        if(isPrime(n)){
            System.out.println(n);
            return;
        }
        int next=n+1, prev=n-1;
        while(true){
            if(isPrime(next)){
                System.out.println(next);
                return;
            }
            if(isPrime(prev)){
                System.out.println(prev);
                return;
            }
            next++;
            prev--;
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
}
