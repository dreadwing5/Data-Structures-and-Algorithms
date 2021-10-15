import java.util.Arrays;

class Lcs {

    static String s1 = "bd";
    static String s2 = "abcd";

    static int m = s1.length();
    static int n = s2.length();
    static int[][] mem = new int[m][n];

    static int[][] dp = new int[m + 1][n + 1];

    // recursive approach

    public static int rlcs(int m, int n) {

        if (m == -1 || n == -1)
            return 0;

        else if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + rlcs(m - 1, n - 1);
        } else {
            return Math.max(rlcs(m - 1, n), rlcs(m, n - 1));
        }

    }

    // Memoized approach

    public static int mlcs(int m, int n) {

        if (mem[m][n] != -1)
            return mem[m][n];
        if (m == -1 || n == -1)
            return 0;

        else if (s1.charAt(m) == s2.charAt(n)) {
            return mem[m][n] = 1 + rlcs(m - 1, n - 1);
        } else {
            return mem[m][n] = Math.max(rlcs(m - 1, n), rlcs(m, n - 1));
        }

    }

    // dp

    public static int dlcs() {
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }

        }

        return dp[m][n];

    }

    public static void main(String[] args) {

        // for (int[] row : mem)
        // Arrays.fill(row, -1);

        // int ans = mlcs(s1.length() - 1, s2.length() - 1);

        // System.out.println(ans);

        System.out.println(dlcs());
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
    }
}