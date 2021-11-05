package com.ilovealt.leetcode.remove_element_27;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *     做题前确认：1.数据范围和边界条件；2.默认返回结果；
 *          原地移除所有数值等于val的元素，并返回新长度；不适用额外数组空间。
 *     解题思路：
 *          第一种：两种索引，分别从头和尾逐渐移动，结束条件为索引相等；
 *                  首索引的所在值都等于val，则切换到尾索引值，等于val则索引-1；不等于val则此值替换首索引所在值，并首索引+1和尾索引-1；
 *                  首索引的所在值都不等于val，则索引值+1往下走；
 *          第二种：两个指针都是从头开始，一个遍历整个数组，一个只遍历不等于val值；
 *      我是用第一种，效率高；
 * </p>
 *
 * @author wangs
 * @since 2021/11/5 6:27
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) { return 0; }
        int i = 0;
        int length = nums.length - 1;
        while (i <= length) {
            if (nums[i] == val) {
                if (nums[length] == val) {
                    length--;
                } else {
                    nums[i] = nums[length];
                    i++;
                    length--;
                }
            } else {
                i++;
            }
        }
        return length + 1;
    }

}
