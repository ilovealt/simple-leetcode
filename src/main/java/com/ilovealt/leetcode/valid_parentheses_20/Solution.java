package com.ilovealt.leetcode.valid_parentheses_20;

import java.util.Stack;

/**
 数据范围、前提条件和边界条件：1 <= s.length <= 10000
 解题思路：
 第一种： 使用栈暂存 左边的括号，遇到右边括号，就从栈中弹出数据进行匹配，匹配失败返回false；
 第二种：
 时间空间复杂度分析：
 总结：
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{'){
                stack.push('}');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.empty();
    }

}
