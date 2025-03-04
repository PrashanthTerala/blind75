public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
//        int[] nums1 = {1, 2}, nums2 = {3, 4};
        double ans = findMedianSortedArrays(nums1, nums2);
        System.out.println(ans);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;

        while (left <= right) {
            int partM = left + (right - left) / 2;
            int partN = (m + n + 1) / 2 - partM;

            int leftPartM = partM == 0 ? Integer.MIN_VALUE : nums1[partM - 1];
            int rightPartM = partM == m ? Integer.MAX_VALUE : nums1[partM];
            int leftPartN = partN == 0 ? Integer.MIN_VALUE : nums2[partN - 1];
            int rightPartN = partN == n ? Integer.MAX_VALUE : nums2[partN];
            if (leftPartM <= rightPartN && leftPartN <= rightPartM) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(leftPartM, leftPartN) + Math.min(rightPartM, rightPartN)) / 2;
                } else {
                    return Math.max(leftPartM, leftPartN);
                }
            } else if (leftPartM > rightPartN) {
                right = partM - 1;
            } else {
                left = partM + 1;
            }
        }

        return 0;
    }
}
