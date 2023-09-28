package com.github.deathbit.leetcode.purecode.p0004.s3;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        boolean isEven = (m + n) % 2 == 0;
        int L3Count = isEven ? (m + n) / 2 : (m + n + 1) / 2;
        int L1CountMin = 0;
        int L1CountMax = m;
        while (L1CountMin <= L1CountMax) {
            int L1Count = (L1CountMin + L1CountMax) / 2;
            int R1Count = m - L1Count;
            int L2Count = L3Count - L1Count;
            int R2Count = n - L2Count;

            int L1 = L1Count > 0 ? nums1[L1Count - 1] : Integer.MIN_VALUE;
            int R1 = R1Count > 0 ? nums1[m - R1Count] : Integer.MAX_VALUE;
            int L2 = L2Count > 0 ? nums2[L2Count - 1] : Integer.MIN_VALUE;
            int R2 = R2Count > 0 ? nums2[n - R2Count] : Integer.MAX_VALUE;

            if (L1 <= R2 && L2 <= R1) {
                if (isEven) {
                    return (double) (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.max(L1, L2);
                }
            }

            if (L1 <= R2) {
                L1CountMin = L1Count + 1;
            } else {
                L1CountMax = L1Count - 1;
            }
        }

        throw new RuntimeException("no solution");
    }
}
