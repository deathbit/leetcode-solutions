package com.github.deathbit.leetcode.solutions.p0005.s1;

/**
 * 解法一：中心扩展法
 * 解题思路：以每个字符为中心，向两侧扩展，注意要
 * 分两种情况讨论，一种是以单个字符为中心的扩展，
 * 类似“aba”这种情况，一种是以两个字符为中心的扩
 * 展，类似“abba”这种情况
 * 时间复杂度：O(N^2)
 * 空间复杂度：O(1)
 */
public class Solution {

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        // 记录结果和最大长度
        String ans = "";
        int ansLen = 0;
        // 扩展指针
        int l; // 左扩展指针
        int r; // 右扩展指针
        for (int i = 0; i < n; i++) {
            // 单个字符为中心的扩展，aba
            l = i;
            r = i;
            while (l >= 0 && r < n && c[l] == c[r]) {
                if (r - l + 1 > ansLen) {
                    ans = s.substring(l, r + 1);
                    ansLen = r - l + 1;
                }
                l--;
                r++;
            }
            // 两个字符为中心的扩展，abba
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && c[l] == c[r]) {
                if (r - l + 1 > ansLen) {
                    ans = s.substring(l, r + 1);
                    ansLen = r - l + 1;
                }
                l--;
                r++;
            }
        }

        return ans;
    }
}
