
/**
 * MaxArea
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int n = height.length;
        int j, w, i;
        int max = 0;

        i = 0;
        j = n - 1;
        while (i < j) {
            w = j - i;
            if (height[i] <= height[j]) {
                max = Math.max(max, height[i] * w);
                i++;
            } else {
                max = Math.max(max, height[j] * w);
                j--;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] height = { 1 };
        System.out.println(maxArea(height));
        // maxArea(height);
    }
}