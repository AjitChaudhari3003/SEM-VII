import java.util.Scanner;

public class DPKnapsack {

    // Function to return the maximum value that can be put in a knapsack of capacity W
    public static int knapsack(int[] weights, int[] profits, int n, int capacity) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the dp array
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], profits[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of items
        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] profits = new int[n];
        int[] weights = new int[n];

        // Input profit and weight for each item
        for (int i = 0; i < n; i++) {
            System.out.print("Enter profit for item " + (i + 1) + ": ");
            profits[i] = scanner.nextInt();
            System.out.print("Enter weight for item " + (i + 1) + ": ");
            weights[i] = scanner.nextInt();
        }

        // Input knapsack capacity
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();
        scanner.close();

        int maxProfit = knapsack(weights, profits, n, capacity);
        System.out.println("Maximum profit achievable = " + maxProfit);
    }
}
