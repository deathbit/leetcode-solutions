package com.github.deathbit.leetcode.solutions.p0014.s1;

/**
 * 解法一：纵向扫描法
 * 解题思路：先计算最短字符串长度，避免后续操作
 * 越界，然后纵向比较每个字符即可，很符合直觉的
 * 解法
 * 时间复杂度：O(m*n) m为字符串平均长度，
 *                  n为字符串数量
 * 空间复杂度：O(1)
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        // 计算最短字符串长度
        int minLen = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            // 比较每个字符串在索引i处是否有相同的字符
            if (isCharAllTheSame(strs, c, i)) {
                sb.append(c);
            } else {
                break;
            }
        }

        return sb.toString();
    }

    private boolean isCharAllTheSame(
            String[] strs, char c, int index) {
        for (String str : strs) {
            if (str.charAt(index) != c) {
                return false;
            }
        }

        return true;
    }
}
