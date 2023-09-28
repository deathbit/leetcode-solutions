package com.github.deathbit.leetcode.purecode.p0004.s2;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int index1 = (m + n) / 2 - 1;
        int index2 = (m + n) / 2;
        int val1 = 0;
        int val2 = 0;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            int val;
            if (i < m && j < n && nums1[i] < nums2[j] || j >= n) {
                val = nums1[i++];
            } else {
                val = nums2[j++];
            }
            if (k == index1) {
                val1 = val;
            }
            if (k == index2) {
                val2 = val;
            }
            k++;
        }

        if (k % 2 == 0) {
            return (double) (val1 + val2) / 2;
        } else {
            return val2;
        }
    }
}
