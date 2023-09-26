package com.github.deathbit.leetcode.solutions.p0001.s1;

/**
 * 解法一：暴力法
 * 解题思路：暴力枚举所有可能情况
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // 外层循环的索引范围：[0, n - 1)
        for (int i = 0; i < n - 1; i++) {
            // 内层循环的索引范围：[i + 1, n)
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new RuntimeException("no solution");
    }
}
