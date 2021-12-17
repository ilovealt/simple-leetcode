package com.ilovealt.leetcode.how_many_numbers_1365;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据范围：2 <= nums.length <= 500； 0 <= nums[i] <= 100；
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
		int[] ints = solution.smallerNumbersThanCurrent(nums);
		System.out.println(Arrays.toString(ints));
		int[] ints1 = solution.smallerNumbersThanCurrent_1(nums);
		System.out.println(Arrays.toString(ints1));
	}

	/**
	 * 使用Map缓存个数
	 */
	public int[] smallerNumbersThanCurrent(int[] nums) {
		//复制数据 排序
		int[] clone = nums.clone();
		Arrays.sort(clone);
		int number = 0;
		int first = clone[0];
		//缓存个数
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < clone.length; i++) {
			int num = clone[i];
			if (first != num) {
				number = i;
				first = num;
			}
			map.put(num, number);
		}

		//形成结果
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = map.get(nums[i]);
		}
		return res;
	}

	/**
	 * 数据范围 ：2 <= nums.length <= 500； 0 <= nums[i] <= 100；
	 * 使用数组的特性处理数组和个数关系
	 */
	public int[] smallerNumbersThanCurrent_1(int[] nums) {
		//根据数据范围创建101尺寸数据，把对应数据放进去，记录出现次数
		int[] arr = new int[101];
		for (int num : nums) {
			arr[num]++;
		}
		//把次数进行累计
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			//大于0的数据才有效
			if (arr[i] > 0) {
				int number = arr[i];
				arr[i] = sum;
				sum = number + sum;
			}
		}
		//形成结果
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = arr[nums[i]];
		}
		return res;
	}

}
