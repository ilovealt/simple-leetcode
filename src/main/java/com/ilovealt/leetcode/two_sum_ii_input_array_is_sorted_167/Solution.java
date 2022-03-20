package com.ilovealt.leetcode.two_sum_ii_input_array_is_sorted_167;

import java.util.Arrays;

/**
 * 数据范围：2 <= numbers.length <= 3 * 10^4; numbers 按 非递减顺序 排列;仅存在一个有效答案;
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{2,7,11,15};
		int[] ints = solution.twoSum(nums, 9);
		System.out.println(Arrays.toString(ints));
		int[] ints1 = solution.twoSum_1(nums, 9);
		System.out.println(Arrays.toString(ints1));
	}

	/**
	 * 二分查找
	 */
	public int[] twoSum(int[] numbers, int target) {
		//核心逻辑
		for (int i = 0; i < numbers.length; i++) {
			int low = i+1, high = numbers.length-1;
			while (low <= high) {
				int mid = low + (high-low)/2;
				if (numbers[mid] == target - numbers[i]) {
					return new int[]{i+1, mid+1};
				} else if (numbers[mid] > target - numbers[i]) {
					high = mid-1;
				} else {
					low = mid+1;
				}
			}
		}
		return new int[]{-1, -1};
	}

	/**
	 * 数据默认有序
	 * 使用双指针向中间夹逼
	 */
	public int[] twoSum_1(int[] numbers, int target) {
		int low = 0, high = numbers.length-1;
		//核心逻辑
		while (low < high) {
			if (numbers[low] == target - numbers[high]) {
				return new int[]{low+1, high+1};
			} else if (numbers[low] > target - numbers[high]) {
				high--;
			} else {
				low++;
			}
		}
		return new int[]{-1, -1};
	}

}
