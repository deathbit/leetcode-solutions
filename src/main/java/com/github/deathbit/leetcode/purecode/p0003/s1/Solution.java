package com.github.deathbit.leetcode.purecode.p0003.s1;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.offer(s.charAt(i));
            ans = Math.max(ans, queue.size());
        }

        return ans;
    }
}
