package com.ilovealt.leetcode.plus_one_66;


/**
 做题前确认数据范围和边界条件：数组都是非负整数且不为空；在该组合数上+1；
    2.默认返回结果：
 解题思路：
    第一种：官方思路关注9的问题；
    第二种：当前位+1等不等0，不等于0直接返回数组，等于0就继续循环，代码最后扩容数组，0位赋值1；
            （YHHZW 解法很厉害）
总结：一开始把这个问题想的太简单了。没有考虑到9进位的问题，以及都是9扩容数组的问题；
    思考问题要全面；思考问题要全面；思考问题要全面；
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) { return digits; }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
