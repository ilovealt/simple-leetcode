package com.ilovealt.leetcode.contains_duplicate_ii_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p> </p>
 *
 * @author wangs
 * @since 2021/12/8 9:19
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{1,0,1,1};
		boolean bool = solution.containsNearbyDuplicate(nums, 1);
		System.out.println(bool);
		boolean bool1 = solution.containsNearbyDuplicate_1(nums, 1);
		System.out.println(bool1);
	}

	/**
	 * 使用集合缓存 值:索引
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				int lastIndex = map.get(num);
				//这是没有使用绝对值，是因为从前向后遍历，
				// 如果存在相同值，则i一定大于上一个的索引
				if (i-lastIndex <= k) {
					return true;
				}
			}
			map.put(num, i);
		}
		return false;
	}

	/**
	 * 使用HashSet保存k范围内的数据，如果存在就是true
	 */
	public boolean containsNearbyDuplicate_1(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i-k]);
			}
		}
		return false;
	}

}
