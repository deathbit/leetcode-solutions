package com.github.deathbit.leetcode.solutions.p0003.s1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解法一：滑动窗口法
 * 解题思路：使用滑动窗口来记录遍历过程中出现的无
 * 重复字符子串，窗口的最大值即为题解
 * 时间复杂度：O(N)
 * 空间复杂度：O(∣Σ∣) Σ表示字符集
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        // 使用队列来模拟滑动窗口
        Queue<Character> queue = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            // 出队直至窗口中不包含当前字符
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            // 入队
            queue.offer(s.charAt(i));
            // 记录窗口历史最大值
            ans = Math.max(ans, queue.size());
        }

        return ans;
    }
}
