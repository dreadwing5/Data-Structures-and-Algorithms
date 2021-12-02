class MedianOfTwoArray {

    public static double median(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left_pointer;
        int right_pointer;
        int total = n + m;
        int half = (total + 1) / 2;
        int[] A, B;
        if (n <= m) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }

        left_pointer = 0;
        right_pointer = A.length;

        while (left_pointer <= right_pointer) {
            int mid1 = (left_pointer + right_pointer) / 2; // mid index of A
            int mid2 = half - mid1; // mid index of B
            int A_left = mid1 > 0 ? A[mid1 - 1] : Integer.MIN_VALUE;
            int A_right = mid1 < A.length ? A[mid1] : Integer.MAX_VALUE;
            int B_left = mid2 > 0 ? B[mid2 - 1] : Integer.MIN_VALUE;
            int B_right = mid2 < B.length ? B[mid2] : Integer.MAX_VALUE;

            // 1. Found the median
            if (A_left <= B_right && B_left <= A_right) {
                // 1. Check for even
                if (total % 2 == 0) {
                    return (double) (Math.max(A_left, B_left) + Math.min(A_right, B_right)) / 2;

                    // 2. Check for odd
                } else {
                    return (double) Math.max(A_left, B_left);

                }
            } else if (A_left > B_right) {
                right_pointer = mid1 - 1;
            }

            // 2. Median Not found, binary search
            else {
                left_pointer = mid1 + 1;
            }

        }

        return 0.0;

    }

    public static void main(String[] args) {
        int[] arr1 = { 2 };
        int[] arr2 = { 1 };
        System.out.println("Median of the two arrays are");
        System.out.println(median(arr1, arr2));
        median(arr1, arr2);
    }
}
