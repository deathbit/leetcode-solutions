package com.github.deathbit.leetcode.solutions.p0012.s1;

/**
 * 解法一：模拟法
 * 解题思路：模拟转换的过程
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
public class Solution {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90,
                50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC",
                "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int repeatTimes = num / values[i];
            for (int j = 1; j <= repeatTimes; j++) {
                sb.append(romans[i]);
            }
            num = num % values[i];
        }

        return sb.toString();
    }
}
