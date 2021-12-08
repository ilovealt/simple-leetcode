package com.ilovealt.leetcode.maximize_sum_of_array_after_k_negations_1005;

import java.util.Arrays;

/**
 * 数据范围：1 <= nums.length <= 10^4; -100 <= nums[i] <= 100; 1 <= k <= 10^4;
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{-4,-2,-3};
		Solution solution = new Solution();
		int sum = solution.largestSumAfterKNegations(nums, 4);
		System.out.println(sum);
	}

	public int largestSumAfterKNegations(int[] nums, int k) {
		int length = nums.length;
		Arrays.sort(nums);
		//最小非负数索引
		int index = 0;
		for (int i = 0; i < length; i++) {
			index = i;
			if (nums[i] >= 0) {
				break;
			}
		}
		System.out.println("index = " + index);
		//遍历k次
		for (int i = 0; i < k; i++) {
			if (index > i) {
				nums[i] = -nums[i];
			} else {
				int before = index > 0 ? index-1 : 0;
				if (nums[before] < nums[index]) {
					nums[before] = -nums[before];
				} else {
					nums[index] = -nums[index];
				}
			}
			System.out.println("   index = " + index + ", i = " + i);
		}
		//求和
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}

	public int largestSumAfterKNegations_1(int[] nums, int k) {
		int length = nums.length;
		Arrays.sort(nums);
		//最小非负数索引
		int index = 0;
		for (int i = 0; i < length; i++) {
			index = i;
			if (nums[i] >= 0) {
				break;
			}
		}
		System.out.println("index = " + index);
		//遍历k次
		int before = index > 0 ? index-1 : 0;
		for (int i = 0; i < k; i++) {
			int cur = Math.min(before, i);
			if (nums[cur] < nums[index]) {
				nums[cur] = -nums[cur];
			} else {
				nums[index] = -nums[index];
			}
			System.out.println("   cur = " + cur + ", i = " + i);
		}
		//求和
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum;
	}

}
