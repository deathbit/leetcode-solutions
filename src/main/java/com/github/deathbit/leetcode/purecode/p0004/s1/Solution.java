package com.github.deathbit.leetcode.purecode.p0004.s1;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i < m && j < n && nums1[i] < nums2[j] || j >= n) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        if (k % 2 == 0) {
            return (double) (nums3[k / 2 - 1] + nums3[k / 2]) / 2;
        } else {
            return nums3[k / 2];
        }
    }
}
