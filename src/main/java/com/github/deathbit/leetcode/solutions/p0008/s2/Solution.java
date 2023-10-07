package com.github.deathbit.leetcode.solutions.p0008.s2;

/**
 * 解法二：有限状态机法（DFA）
 * 解题思路：DFA - Deterministic Finite Automaton
 * 有限状态机是自动机的一种，对于一个给定的状态和字符，
 * 根据状态机的状态转移函数转移到下一个状态，状态转移
 * 方程为：
 * nextState = f(currentState, inputCharacter)
 * 时间复杂度：O(N)
 * 空间复杂度：O(1)
 */
public class Solution {

    // 状态机的四种状态
    private enum State {
        START, SIGNED, IN_NUMBER, END
    }

    public int myAtoi(String s) {
        // 状态机总共四行四列，每行依次代表状态机
        // 当前可能得四种状态四列代表输入空格、正
        // 负号、数字、其它字符时，状态机的下一个
        // 状态
        State[][] automaton = new State[][]{
                {State.START, State.SIGNED,
                        State.IN_NUMBER, State.END},
                {State.END, State.END,
                        State.IN_NUMBER, State.END},
                {State.END, State.END,
                        State.IN_NUMBER, State.END},
                {State.END, State.END,
                        State.END, State.END}
        };
        char[] c = s.toCharArray();
        int n = c.length;
        State state = State.START; // 初始状态
        int sign = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 计算状态机下一个状态
            state = automaton[state.ordinal()][getColumn(c[i])];
            if (state == State.SIGNED) {
                sign = c[i] == '+' ? 1 : -1;
            } else if (state == State.IN_NUMBER) {
                int digit = sign * (c[i] - '0');
                // 判断越界
                if ((ans > Integer.MAX_VALUE / 10)
                        || (ans < Integer.MIN_VALUE / 10)
                        || (ans == Integer.MAX_VALUE / 10
                        && digit > Integer.MAX_VALUE % 10)
                        || (ans == Integer.MIN_VALUE / 10
                        && digit < Integer.MIN_VALUE % 10)) {
                    return sign > 0 ? Integer.MAX_VALUE
                            : Integer.MIN_VALUE;
                }
                ans = ans * 10 + digit;
            } else if (state == State.END) {
                break;
            }
        }

        return ans;
    }

    private int getColumn(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        }

        return 3;
    }
}
