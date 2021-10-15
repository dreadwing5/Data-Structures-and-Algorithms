import java.util.Arrays;

class KnapSack {

    static int val[] = new int[] { 1, 3, 4, 5 };
    static int wt[] = new int[] { 1, 3, 4, 7 };
    static int maxCapacity = 4;
    static int[][] mem = new int[val.length + 1][maxCapacity + 1];
    static int[][] dp = new int[val.length + 1][maxCapacity + 1];

    public static int rec_knapsack(int n, int weight) {

        // Base condition

        if (n == 0 || weight == 0) {
            return 0;
        }

        // We can have two possibilities, either the wt is less than maxCapacity, or
        // greater than maxCapacity
        if (wt[n - 1] > weight) {
            return rec_knapsack(n - 1, weight);
        } else

        {

            return Math.max(val[n - 1] + rec_knapsack(n - 1, weight - wt[n - 1]), rec_knapsack(n - 1, weight));

            // We can have two outcomes, either include the weight or don't include it

        }

    }

    public static int mem_knapsack(int n, int weight) {

        // Base condition

        if (n == 0 || weight == 0) {
            return 0;
        }

        if (mem[n][weight] != -1)
            return mem[n][weight];

        // We can have two possibilities, either the wt is less than maxCapacity, or
        // greater than maxCapacity
        if (wt[n - 1] > weight) {
            return mem[n][weight] = rec_knapsack(n - 1, weight);
        } else

        {

            return mem[n][weight] = Math.max(val[n - 1] + rec_knapsack(n - 1, weight - wt[n - 1]),
                    rec_knapsack(n - 1, weight));

            // We can have two outcomes, either include the weight or don't include it

        }

    }

    public static int knapsack_dp(int n, int weight) {

        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < weight + 1; j++) {

                if (wt[i - 1] > j) {
                    dp[i][j] = knapsack_dp(i - 1, j);
                } else
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][weight - wt[i - 1]], dp[i - 1][j]);
            }

        }

        return dp[n][weight];
    }

    public static void main(String[] args) {
        // int ans = rec_knapsack(wt.length, maxCapacity);

        // Initial mem array to -1
        for (int[] row : mem) {

            Arrays.fill(row, -1);

        }

        // int ans = mem_knapsack(wt.length, maxCapacity);

        // System.out.println(ans);

        // for (int[] rows : mem) {
        // System.out.println(Arrays.toString(rows));

        // }

        int ans = knapsack_dp(wt.length, maxCapacity);

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));

        }
        System.out.println(ans);
    }
}