package com.github.deathbit.leetcode.solutions.p0008.s1;

/**
 * 解法一：模拟法
 * 解题思路：模拟转换过程，总计分为三个步骤
 * 1. 处理前置空格
 * 2. 处理数字符号
 * 3. 处理数字
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int myAtoi(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int i = 0; // i指针代表当前处理的字符
        // 处理前置空格
        while (i < n) {
            if (c[i] != ' ') {
                break;
            }
            i++;
        }
        // 处理数字符号
        int sign = 1;
        // 注意此处数组不要越界
        if (i < n && (c[i] == '+' || c[i] == '-')) {
            if (c[i] == '-') {
                sign = -1;
            }
            i++;
        }
        // 处理数字
        int ans = 0;
        while (i < n) {
            if (!Character.isDigit(c[i])) {
                break;
            }
            // 注意此处数字需要带符号
            int digit = sign * (c[i] - '0');
            // 判断越界
            if ((ans > Integer.MAX_VALUE / 10)
                    || (ans < Integer.MIN_VALUE / 10)
                    || (ans == Integer.MAX_VALUE / 10
                    && digit > Integer.MAX_VALUE % 10)
                    || (ans == Integer.MIN_VALUE / 10
                    && digit < Integer.MIN_VALUE % 10)) {
                return sign > 0 ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }

        return ans;
    }
}
