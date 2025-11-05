public class FriendsPairingProblem {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Total ways to pair " + n + " friends: " + friendsPairing(n));
    }
    
    // Method-I
    public static int friendsPairing(int n){
        if(n == 1 || n == 2) return n;

        // choice 1: single
        int fnm1 = friendsPairing(n-1);
        
        // choice 2: pair
        int fnm2 = friendsPairing(n-2);
        int totalWays = fnm1 + (n-1) * fnm2;
        return totalWays;
    }

    // Method-II
    public static int friendsPairing2(int n){
        if(n == 1 || n == 2) return n;

        return friendsPairing2(n-1) + (n-1) * friendsPairing2(n-2);
    }
}
