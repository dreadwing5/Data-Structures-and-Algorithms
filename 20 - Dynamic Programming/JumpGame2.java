public class JumpGame2 {

    public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i + 1;
            int min = Integer.MAX_VALUE;
            while (j <= nums.length - 1 && j <= i + nums[i]) {
                min = Math.min(dp[j], min);
                j++;
            }

            if (min != Integer.MAX_VALUE)
                dp[i] = 1 + min;

            if (nums[i] == 0 || dp[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            }

        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0 };
        System.out.println(jump(arr));
    }

}
