package com.ilovealt.leetcode.intersection_of_two_arrays_ii_350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 数据范围、前提条件和边界条件： 需要判空和null
 总结：
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums1 = new int[]{4,9,5,4,4};
		int[] nums2 = new int[]{9,4,9,8,4,6};
		int[] ints = intersection(nums1, nums2);
		System.out.println(Arrays.toString(ints));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 ||
				nums2 == null || nums2.length == 0) {
			return null;
		}

		return method1(nums1, nums2);
	}

	/**
	 *  类型：排序
	 *  解题思路：
	 *  时间复杂度：
	 *  空间复杂度:
	 */
	private static int[] method1(int[] nums1, int[] nums2) {
		//去重
		if (nums1.length > nums2.length) {
			return method1(nums2, nums1);
		}
		//计数
		Map<Integer, Integer> map = new HashMap<>(nums1.length);
		for (int num : nums1) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		//搬运数据
		int[] newInt = new int[nums1.length];
		int index = 0;
		for (int num : nums2) {
			Integer count = map.get(num);
			if (count != null && count > 0) {
				newInt[index++] = num;
				map.put(num, --count);
			}
		}

		return Arrays.copyOfRange(newInt, 0, index);
	}


}
