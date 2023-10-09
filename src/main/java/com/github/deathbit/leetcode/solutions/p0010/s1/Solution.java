package com.github.deathbit.leetcode.solutions.p0010.s1;

/**
 * 解法一：动态规划法
 * 解题思路：boolean dp[i][j]表示字符串
 * S(0,i-1)与模式串P(0,j-1)是否匹配，则
 * 动态规划状态转移方程推导如下：
 * 1. 模式串最后一位为常规字符
 * dp[i][j] = dp[i-1][j-1] if S[i-1]=P[j-1]
 * 示例：S='####a' P='####a'
 * 2. 模式串最后一位为'.'字符
 * dp[i][j] = dp[i-1][j-1]
 * 示例：S='####a' P='####.'
 * 3. 模式串最后一位为'*'字符
 * 示例：S='####a' P='####*'
 * 3.1 S[i-1]==P[j-2] || P[j-2]=='.'
 * 示例：S='####a' P='###a*'或'###.*'
 * 3.1.1 匹配0次：dp[i][j] = dp[i][j-2]（直接消去a*）
 * 示例：S='####a' P='###'
 * 3.1.2 匹配1次：dp[i][j] = dp[i-1][j-2]（直接消去a*）
 * 示例：S='####' P='###'
 * 3.1.3 匹配多次：dp[i][j] = dp[i-1][j]（不消去a*）
 * 示例：S='####' P='###a*'（a*继续使用）
 * 3.2 S[i-1]!=P[j-2]
 * 示例：S='####a' P='###b*'
 * 3.2.1 dp[i][j] = dp[i][j-2]（直接消去b*）
 * 基础情况
 * 1. S、P都为空串：dp[0][0] = true
 * 2. S为空串，P为非空串：dp[0][i] = dp[0][i-2] if P[i-1]=='*'
 * 3. S为非空串，P为空串：dp[i][0] = false if i > 0
 * 时间复杂度：O(m*n)
 * 空间复杂度：O(m*n)
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = ss.length;
        int n = pp.length;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (pp[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 模式串最后一位P[j-1]为常规字符
                if (pp[j - 1] != '.' && pp[j - 1] != '*') {
                    if (ss[i - 1] == pp[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
                // 模式串最后一位P[j-1]为'.'
                if (pp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 模式串最后一位P[j-1]为'*'
                if (pp[j - 1] == '*') {
                    if (pp[j - 2] == ss[i - 1] || pp[j - 2] == '.') {
                        boolean matchNone = dp[i][j - 2];
                        boolean matchOnce = dp[i - 1][j - 2];
                        boolean matchMore = dp[i - 1][j];
                        dp[i][j] = matchNone || matchOnce
                                || matchMore;
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[m][n];
    }
}
