package com.ilovealt.leetcode.remove_duplicates_from_sorted_array_26;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *      2021/11/4 8:38
 *      做题前确认：1.数据范围和边界条件；2.默认返回结果；
 *          1.原数据有顺序；原地删除重复数据；每个数据出现一次；
 *          2.返回新长度
 *     解题思路：
 *         第一种：遍历整个数组，因为有序所以遇到几个连续相同数据，记录第一个数据索引index和数据长度length，
 *                并向后继续遍历，遇到第一个不同数据，把index+1和length+1；
 *     我是用第一种方法；
 *     * 这是一种双指针方式，快慢指针；
 * </p>
 *
 * @author wangs
 * @since 2021/11/4 8:38
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) { return 0; }
        int index = 0;
        int length = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num != nums[i]) {
                num = nums[i];
                nums[++index] = nums[i];
                length++;
            }
        }
        return length;
    }

}
