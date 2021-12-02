import java.util.Arrays;

public class TwoSum2 {

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int n = numbers.length;
        int j = n - 1;
        int[] arr = new int[2];
        while (i < n) {
            if (numbers[i] + numbers[j] < target)
                i++;
            if (numbers[i] + numbers[j] > target)
                j--;
            if (numbers[i] + numbers[j] == target) {
                arr[0] = i + 1;
                arr[1] = j + 1;
                return arr;
            }

        }
        return arr;

    }

    public static void main(String[] args) {
        int[] numbers = { -1, 0 };
        int[] ans = twoSum(numbers, -1);
        System.out.println(Arrays.toString(ans));
    }
}
