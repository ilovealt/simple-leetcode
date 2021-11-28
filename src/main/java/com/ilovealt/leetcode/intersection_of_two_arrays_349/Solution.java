package com.ilovealt.leetcode.intersection_of_two_arrays_349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 数据范围、前提条件和边界条件： 需要判空和null
 总结：
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums1 = new int[]{4,9,5};
		int[] nums2 = new int[]{9,4,9,8,4};
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
	 *  解题思路： 使用短数组创建set集合去重，再遍历长数组，把set中包含的数据重新存一份作为交集
	 *  时间复杂度：O(n1+n2) = O(n) (n为最长数组)
	 *  空间复杂度: O(n1+n0) O(n0) (n0为交集)
	 */
	private static int[] method1(int[] nums1, int[] nums2) {
		//去重
		Set<Integer> set = new HashSet<>(nums1.length);
		for (int num : nums1) {
			set.add(num);
		}
		//交集
		Set<Integer> list = new HashSet<>(set.size());
		for (int num : nums2) {
			if (set.contains(num)) {
				list.add(num);
			}
		}
		//转成数组
		int[] newInt = new int[list.size()];
		int i = 0;
		for (Integer integer : list) {
			newInt[i++] = integer;
		}
		return newInt;
	}

}
