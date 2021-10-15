public class CoinChange {

    static int[] coins = { 1, 2, 3 };
    static int res = 0;

    public static int rcoin_change(int n, int sum) {

        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;
        res = rcoin_change(n - 1, sum);
        if (sum - coins[n - 1] >= 0) {
            res += rcoin_change(n, sum - coins[n - 1]);
        }

        return res;
    }

    public static int dp_coin_change(int n, int sum) {

        int[][] dp = new int[sum + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= sum; i++) {

            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];

                if (i - coins[j - 1] >= 0) {
                    dp[i][j] += dp[i - coins[j - 1]][j];
                }
            }

        }

        return dp[sum][n];
    }

    public static void main(String[] args) {
        int ans = dp_coin_change(coins.length, 4);
        System.out.println(ans);
    }
}
