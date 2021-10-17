public class EqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        int sum = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
        }

        if (sum % 2 != 0)
            return false;

        int N = nums.length;
        int S = sum / 2;
        int[][] dp = new int[N + 1][S + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int s = 1; s < S + 1; s++) {
                if (nums[i - 1] <= s) {
                    dp[i][s] = Math.max(nums[i - 1] + dp[i - 1][s - nums[i - 1]], dp[i - 1][s]);
                } else
                    dp[i][s] = dp[i - 1][s];
            }
        }

        if (dp[N][S] != S)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 11, 5 };

        boolean ans = canPartition(arr);

        System.out.println(ans);
    }
}
