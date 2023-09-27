package com.github.deathbit.leetcode.solutions.p0004.s2;

/**
 * 解法二：计数法
 * 解题思路：其实我们并不需要真正的去合并数组，我
 * 们只要找到合并数组中下标为(m+n)/2和(m+n)/2-1
 * 的两个元素即可，这样可以为我们节省额外的空间
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(1)
 * 备注：该时间复杂度不符合题目要求
 */
public class Solution {

    public double findMedianSortedArrays(
            int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // 需要寻找的下标和元素
        int index1 = (m + n) / 2 - 1;
        int index2 = (m + n) / 2;
        int val1 = 0;
        int val2 = 0;

        // 合并两个有序数组
        int i = 0; // nums1数组指针
        int j = 0; // nums2数组指针
        int k = 0; // 合并数组的下标
        while (i < m || j < n) {
            int val;
            if (i < m && j < n && nums1[i] < nums2[j]
                    || j >= n) {
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

        // 返回中位数
        if (k % 2 == 0) {
            return (double) (val1 + val2) / 2;
        } else {
            return val2;
        }
    }
}
