package com.ilovealt.leetcode.two_sum_1;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *      做题前确认：1.数据范围和边界条件；2.默认返回结果；
 *     其他解题思路：
 *         第一种：使用穷举方法，两层for循环嵌套；
 *         第二种：使用Map(值:索引)，target - nums[i] 每次计算判断Map中有没有;
 *     我是用第二种方法；
 * </p>
 *
 * @author wangs
 * @since 2021/11/4 8:20
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
