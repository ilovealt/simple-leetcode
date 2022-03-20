package com.ilovealt.leetcode.maximum_subarray_53;

/**
 * 数据范围：
 * 总结：
 */
public class Solution {

	/**
	 *  类型：排序
	 *  解题思路：
	 *  时间复杂度：
	 *  空间复杂度:
	 */
	public static void main(String[] args) {
	}

	/**
	 *  类型：动态规划
	 *  解题思路： 方程式 f(i)=max{f(i−1)+nums[i],nums[i]}
	 *  时间复杂度：O(n)
	 *  空间复杂度: O(1)
	 */
	public int maxSubArray(int[] nums) {
		int pre = 0, maxAns = nums[0];
		for (int x : nums) {
			pre = Math.max(pre+x, x);
			maxAns = Math.max(maxAns, pre);
		}
		return maxAns;
	}

}
