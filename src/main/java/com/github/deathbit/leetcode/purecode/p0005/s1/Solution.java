package com.github.deathbit.leetcode.purecode.p0005.s1;

public class Solution {

    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        String ans = "";
        int ansLen = 0;

        int l;
        int r;
        for (int i = 0; i < n; i++) {
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
