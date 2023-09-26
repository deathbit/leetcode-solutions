package com.github.deathbit.leetcode.solutions.p0001.s2;

import java.util.HashMap;
import java.util.Map;

/**
 * 解法二：哈希法
 * 解题思路：使用哈希表来降低查找元素的时间，空间
 * 换时间
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // 哈希表结构：value -> array_index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new RuntimeException("no solution");
    }
}
