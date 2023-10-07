package com.github.deathbit.leetcode.solutions.p0009.s1;

/**
 * 解法一：模拟法
 * 解题思路：模拟反转的过程，注意边界情况
 * 时间复杂度：O(log(x))
 * 空间复杂度：O(1)
 */
public class Solution {

    public boolean isPalindrome(int x) {
        // 负数一定不是回文数
        if (x < 0) {
            return false;
        }

        int originalX = x;
        int reversedX = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // 判断越界
            if (reversedX > Integer.MAX_VALUE / 10
                    || (reversedX == Integer.MAX_VALUE / 10
                    && digit > Integer.MAX_VALUE % 10)) {
                return false;
            }

            reversedX = reversedX * 10 + digit;
        }

        return originalX == reversedX;
    }
}
