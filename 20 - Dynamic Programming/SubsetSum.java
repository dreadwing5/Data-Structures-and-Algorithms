import java.util.Arrays;

class SubsetSum {

    public static boolean isSubsetSum(int[] arr, int[][] dp, int N, int W) {

        for (int i = 1; i < N + 1; i++) {

            for (int w = 1; w < W + 1; w++) {

                if (arr[i - 1] <= w)
                    dp[i][w] = Math.max(arr[i - 1] + dp[i - 1][w - arr[i - 1]], dp[i - 1][w]);

                else
                    dp[i][w] = dp[i - 1][w];
            }

        }

        if (dp[N][W] != W)
            return false;

        return true;
    }

    public static void main(String[] args) {
        int S = 14;
        int[] arr = { 2, 3, 7, 8, 10 };
        int[][] dp = new int[arr.length + 1][S + 1];

        boolean ans = isSubsetSum(arr, dp, arr.length, S);

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));

        }
        System.out.println(ans);
    }
}