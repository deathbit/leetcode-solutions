package com.github.deathbit.leetcode.solutions.p0013.s1;

import java.util.HashMap;
import java.util.Map;

/**
 * 解法一：模拟法
 * 解题思路：模拟转换的过程
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution {

    public int romanToInt(String s) {
        // 使用map来保存每个罗马字符代表的价值
        Map<Character, Integer> map =
                new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        char[] c = s.toCharArray();
        int n = c.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 如果下一个字符的价值比当前字符大，
            // 就减去该价值，否则加上该价值
            if (i + 1 < n && map.get(c[i]) < map.get(c[i+1])) {
                ans -= map.get(c[i]);
            } else {
                ans += map.get(c[i]);
            }
        }

        return ans;
    }
}
