package com.github.deathbit.leetcode.purecode.p0005.s2;

public class Solution {

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (c[i] == c[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + (len - 1) < n; i++) {
                int l = i;
                int r = i + (len - 1);
                if (c[l] == c[r] && dp[l + 1][r - 1]) {
                    dp[l][r] = true;
                }
            }
        }

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
