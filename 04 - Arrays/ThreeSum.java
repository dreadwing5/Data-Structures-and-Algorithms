import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int j, k, newTarget;
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            newTarget = 0 - nums[i];
            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] < newTarget)
                    j++;
                else if (nums[j] + nums[k] > newTarget)
                    k--;
                else {
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[k])));
                    k--;
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;

                    }
                    while (nums[k + 1] == nums[k] && j < k) {
                        k--;
                    }

                }

            }

        }
        return list;
    }

    public static void main(String[] args) {

        int[] nums = { -2, 0, 0, 2, 2 };
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> list2 : list) {
            System.out.println(list2);

        }

    }

}
