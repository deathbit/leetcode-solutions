package com.github.deathbit.leetcode.solutions.p0004.s1;

/**
 * 解法一：暴力法
 * 解题思路：合并两个有序数组，返回中位数
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(m+n)
 * 备注：该时间复杂度不符合题目要求
 */
public class Solution {

    public double findMedianSortedArrays(
            int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 使用一个新数组来保存合并后的数组
        int[] nums3 = new int[m + n];

        // 合并两个有序数组
        int i = 0; // nums1数组指针
        int j = 0; // nums2数组指针
        int k = 0; // nums3数组指针
        while (i < m || j < n) {
            if (i < m && j < n && nums1[i] < nums2[j]
                    || j >= n) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }

        // 返回中位数
        if (k % 2 == 0) {
            return (double) (nums3[k / 2 - 1]
                    + nums3[k / 2]) / 2;
        } else {
            return nums3[k / 2];
        }
    }
}
