package com.github.deathbit.leetcode.solutions.p0005.s2;

/**
 * 解法二：动态规划法
 * 解题思路：如果S[i..j]为回文串，那么在S[i..j]
 * 两侧添加一个相同的字符会得到一个新的回文串，以此
 * 为基础，使用动态规划求解。用dp[i][j]表示子串
 * S[i..j]是否为回文串，则动态规划状态转移方程为：
 * dp[i][j] = c[i] == c[j] && dp[i+1][j-1]，
 * 边界条件为：
 * - 单个字符一定为回文串，即dp[i][i] = true
 * - 两个相同的字符在一起一定为回文串，即
 * dp[i][i+1] = true if c[i] = c[i+1]
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(N^2)
 */
public class Solution {

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        // dp[i][j]表示子串S[i..j]是否为回文串
        boolean[][] dp = new boolean[n][n];
        // 边界情况1，子串长度为1时必定是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 边界情况2，子串长度为2时，字符相等为回文串
        for (int i = 0; i < n - 1; i++) {
            if (c[i] == c[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        // 从子串长度3开始枚举，计算所有可能情况
        // dp[i][j] = c[i] == c[j] && dp[i+1][j-1]
        for (int len = 3; len <= n; len++) {
            // 子串索引为：[i, i + (len - 1)] = [l, r]
            for (int i = 0; i + (len - 1) < n; i++) {
                int l = i;
                int r = i + (len - 1);
                if (c[l] == c[r] && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                }
            }
        }
        // 搜索动态规划表格，获取结果
        String ans = "";
        int ansLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j] && j - i + 1 > ansLen) {
                    ans = s.substring(i, j + 1);
                    ansLen = j - i + 1;
                }
            }
        }

        return ans;
    }
}
