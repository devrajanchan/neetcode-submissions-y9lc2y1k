class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            double L1 = (partitionX == 0) ? Double.NEGATIVE_INFINITY : nums1[partitionX - 1];
            double R1 = (partitionX == m) ? Double.POSITIVE_INFINITY : nums1[partitionX];

            double L2 = (partitionY == 0) ? Double.NEGATIVE_INFINITY : nums2[partitionY - 1];
            double R2 = (partitionY == n) ? Double.POSITIVE_INFINITY : nums2[partitionY];

            if (L1 <= R2 && L2 <= R1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }
            } else if (L1 > R2) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        return 0.0; 
    }
}