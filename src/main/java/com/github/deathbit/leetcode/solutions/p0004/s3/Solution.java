package com.github.deathbit.leetcode.solutions.p0004.s3;

/**
 * 解法三：二分法
 * 解题思路：
 * nums1: [...L1] | [R1...] (m)
 * nums2: [...L2] | [R2...] (n)
 * nums3: [...L3] | [R3...] (m + n)
 * nums3为合并后的数组，正确的划分需要满足以下特性：
 * - nums3_left = nums1_left ∪ nums2_left
 * - nums3_right = nums1_right ∪ nums2_right
 * - L1 <= R1、R2（默认L1 <= R1，因为是有序数组）
 * - L2 <= R1、R2（默认L2 <= R2，因为是有序数组）
 * - L3 = Math.max(L1, L2) R3 = Math.min(R1, R2)
 * - nums3大小为偶数时（(m + n) % 2 == 0）
 * -- 左边个数 = 右边个数 = (m + n) / 2
 * -- 题解为：(L3 + R3) / 2
 * - nums3大小为奇数时（(m + n) % 2 != 0）
 * -- 左边个数 = 右边个数 + 1 = (m + n + 1) / 2
 * -- 题解为：L3
 * 只要确认我们需要从nums1中顺序取多少个元素，问题
 * 就迎刃而解，因此对有序的nums1数组执行二分法
 * 时间复杂度：O(log(min(m, n)))
 * 空间复杂度：O(1)
 */
public class Solution {

    public double findMedianSortedArrays(
            int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 对较小的数组执行二分，以获取
        // O(log(min(m, n)))的时间复杂度
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // 合并数组元素个数奇偶性
        boolean isEven = (m + n) % 2 == 0;
        // 合并数组左侧有多少个元素，合并数组总数
        // 为奇数时，我们让左侧多一个元素
        int L3Count = isEven ? (m + n) / 2 : (m + n + 1) / 2;
        // nums1左侧我们顺序取元素的个数
        // 范围:[L1CountMin, L1CountMax]
        // 我们最少取0个元素，最多取m个
        int L1CountMin = 0;
        int L1CountMax = m;
        // 终止条件 L1CountMin > L1CountMax
        while (L1CountMin <= L1CountMax) {
            // 用L1Count表示nums1数组顺序取元素个数，
            // 以此类推，执行二分搜索，取中间个数
            int L1Count = (L1CountMin + L1CountMax) / 2;
            int R1Count = m - L1Count;
            int L2Count = L3Count - L1Count;
            int R2Count = n - L2Count;
            // 计算L1、R1、L2、R2
            int L1 = L1Count > 0 ? nums1[L1Count - 1]
                    : Integer.MIN_VALUE;
            int R1 = R1Count > 0 ? nums1[m - R1Count]
                    : Integer.MAX_VALUE;
            int L2 = L2Count > 0 ? nums2[L2Count - 1]
                    : Integer.MIN_VALUE;
            int R2 = R2Count > 0 ? nums2[n - R2Count]
                    : Integer.MAX_VALUE;
            // 找到解
            if (L1 <= R2 && L2 <= R1) {
                if (isEven) {
                    return (double) (Math.max(L1, L2)
                            + Math.min(R1, R2)) / 2;
                } else {
                    return Math.max(L1, L2);
                }
            }
            // 循环迭代
            if (L1 <= R2) {
                // 没找到解，说明L1还可以更大，向右缩小范围
                L1CountMin = L1Count + 1;
            } else {
                // 没找到解，说明L1还可以更小，向左缩小范围
                L1CountMax = L1Count - 1;
            }
        }

        throw new RuntimeException("no solution");
    }
}
