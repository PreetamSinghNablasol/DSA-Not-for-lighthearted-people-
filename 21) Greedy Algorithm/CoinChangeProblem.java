import java.util.Arrays;

class CoinChangeProblem {
    public static void main(String[] args) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 10, 1000 };
        int amount = 2035;
        System.out.println("Coins available : " + Arrays.toString(coins));
        System.out.println("Target amount: " + amount);
        CoinChange.coinChangeProblem(coins, amount);
    }
}

class CoinChange {
    static void coinChangeProblem(int[] coins, int N) {
        Arrays.sort(coins); // merge sort
        int index = coins.length - 1;
        while (true) {
            int coinValue = coins[index];
            index--;
            int maxAmount = (N / coinValue) * coinValue;
            if (maxAmount > 0) {
                System.out.println("Coin value: " + coinValue + " taken count : " + (N / coinValue));
                N = N - maxAmount;
            }
            if (N == 0)
                break;
        }
    }
}