package com.github.deathbit.leetcode.solutions.p0011.s1;

/**
 * 解法一：双指针法
 * 解题思路：设左右指针指向数组的两端，每次总是
 * 移动较短的指针，直至两个指针重合，计算出现的
 * 最大面积。
 * S = (R - L) * Math.min(height[L], height[R])
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int maxArea(int[] height) {
        // 左右指针
        int l = 0;
        int r = height.length - 1;
        // 记录最大面积
        int maxArea = 0;
        // 终止条件为左右指针重合
        while (l < r) {
            // 计算新面积
            int newArea = (r - l) * Math.min(height[l], height[r]);
            // 更新最大面积
            maxArea = Math.max(maxArea, newArea);
            // 移动指针
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
