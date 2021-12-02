public class RotatedSortedArray {

    public static void main(String[] args) {
        int nums[] = { 4, 6, 6, 7, 0, 1, 2 };
        int target = 0;
        int mid;
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            mid = (l + h) / 2;
            if (nums[mid] == target) {
                System.out.println(mid);
                break;
            } else if (nums[l] < nums[mid]) {
                if (target < nums[mid])
                    h = mid - 1;
                else
                    l = mid + 1;

            } else {
                if (target > nums[mid])
                    l = mid + 1;
                else
                    h = mid - 1;
            }

        }
    }
}
