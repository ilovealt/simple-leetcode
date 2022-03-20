package com.ilovealt.leetcode.set_mismatch_645;

import java.util.Arrays;

/**
 * 数据范围：1 <= nums[i] <= 10^4;2 <= nums.length <= 10^4
 * 总结：
 */
public class Solution {

	/**
	 *  类型：排序
	 *  解题思路：先排序，数据有序，则数据之间就存在关系：如果重复，则前后相等；如果缺失，则前后差>1；
	 *  时间复杂度：O(nlogn)
	 *  空间复杂度:O(logn)
	 */
	public int[] findErrorNums(int[] nums) {
		int[] errorNumbs = new int[2];
		int n = nums.length;
		Arrays.sort(nums);
		//上一个值
		int prev = 0;
		//遍历 处理相等和跳跃的问题
		for (int curr : nums) {
			if (curr == prev) {
				errorNumbs[0] = prev;
			} else if (curr - prev > 1) {
				errorNumbs[1] = prev + 1;
			}
			prev = curr;
		}
		//处理末尾数缺失情况
		if (nums[n-1] != n) {
			errorNumbs[1] = n;
		}
		return errorNumbs;
	}

}
