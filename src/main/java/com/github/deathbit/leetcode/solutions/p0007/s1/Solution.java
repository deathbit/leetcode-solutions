package com.github.deathbit.leetcode.solutions.p0007.s1;

/**
 * 解法一：模拟法
 * 解题思路：模拟反转的过程，注意边界情况
 * 时间复杂度：O(log(x))
 * 空间复杂度：O(1)
 */
public class Solution {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // rev * 10 会越界吗？
            if (rev > Integer.MAX_VALUE / 10
                    || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // 加上digit以后呢？
            if ((rev == Integer.MAX_VALUE / 10
                    && digit > Integer.MAX_VALUE % 10)
                    || (rev == Integer.MIN_VALUE / 10
                    && digit < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            rev = rev * 10 + digit;
        }

        return rev;
    }
}
