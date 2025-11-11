import java.util.ArrayList;

public class IndianCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int amount = 2893;
        System.out.println("Minimum number of coins required: " + minCoins(coins, amount));
    }

    public static int minCoins(int[] coins, int amount) {
        ArrayList<Integer> coinList = new ArrayList<>();

        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                coinList.add(coins[i]);
                count++;
            }
        }
        System.out.println("Coins used: " + coinList);
        return count;
    }
}
