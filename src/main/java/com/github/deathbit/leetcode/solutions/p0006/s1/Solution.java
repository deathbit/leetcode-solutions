package com.github.deathbit.leetcode.solutions.p0006.s1;

/**
 * 解法一：找规律
 * 解题思路：s="HELLOWORLD" row=4
 *       H E L L O W O R L D
 * index 0 1 2 3 4 5 6 7 8 9
 *   row 1 2 3 4 3 2 1 2 3 4
 * row_1 H           O
 * row_2   E       W   R
 * row_3     L   O       L
 * row_4       L           D
 * result: HO_EWR_LOL_LD
 * 使用row数组记录每个字符所在的行号，最后输出
 * 题解，可以想象成一个乒乓球在两块木板之间弹跳，
 * 碰到木板后需要改变乒乓球的运动方向
 * 时间复杂度：O(N*R)
 * 空间复杂度：O(N)
 */
public class Solution {

    public String convert(String s, int numRows) {
        // row=1时特殊处理，可以简化后续处理
        if (numRows == 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int n = c.length;
        // 使用数组a记录每个字符所在的行数
        int[] a = new int[n];
        int row = 1; // 默认在第一行
        // isUp为true时代表方向向上，行数递减
        // 因为我们是先确认方向，再计算下一个元素，
        // 在首行时需要确保下一次能将方向切换为向
        // 下，所以设置初始方向为向上
        boolean isUp = true;
        for (int i = 0; i < n; i++) {
            a[i] = row;
            // 切换方向
            if (row == 1 || row == numRows) {
                isUp = !isUp; // 切换成当前相反方向
            }
            // 计算下一个元素，向上就递减，向下就递增
            row = isUp ? row - 1 : row + 1;
        }
        // 根据a数组记录的行号生成最终结果
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] == i) {
                    sb.append(c[j]);
                }
            }
        }

        return sb.toString();
    }
}
