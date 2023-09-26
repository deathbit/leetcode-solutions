package com.github.deathbit.leetcode.solutions.p0002.s1;

import com.github.deathbit.leetcode.solutions.common.ListNode;

/**
 * 解法一：模拟法
 * 解题思路：模拟加法过程
 * 时间复杂度：O(max(m,n))
 * 空间复杂度：O(1)
 */
public class Solution {

    public ListNode addTwoNumbers(
            ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();
        ListNode op = dummyHead; // 操作指针
        int carry = 0; // 表示进位
        while (l1 != null || l2 != null || carry > 0) {
            // 和由三部分组成：l1.val + l2.val + carry
            int sum = (l1 != null ? l1.val : 0)
                    + (l2 != null ? l2.val : 0)
                    + carry;
            // 生成新节点
            op.next = new ListNode(sum % 10);
            // 计算进位
            carry = sum / 10;
            // 移动指针
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            op = op.next;
        }

        return dummyHead.next;
    }
}
