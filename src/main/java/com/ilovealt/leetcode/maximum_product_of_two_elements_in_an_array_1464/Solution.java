package com.ilovealt.leetcode.maximum_product_of_two_elements_in_an_array_1464;

/**
 * 数据范围：2 <= nums.length <= 500;1 <= nums[i] <= 10^3;
 * 前提条件：
 * 边界条件：
 * 总结：
 */
public class Solution {

	/**
	 *  查找
	 *  解题思路：找到最大和次大
	 *  时间复杂度：O(n)
	 *  空间复杂度:O(1)
	 */
	public int maxProduct(int[] nums) {
		//最大
		int a;
		//次大
		int b;
		if (nums[0] > nums[1]) {
			a = nums[0];
			b = nums[1];
		} else {
			a = nums[1];
			b = nums[0];
		}
		for(int i = 2;i < nums.length; i++) {
			if (a < nums[i]) {
				b = a;
				a = nums[i];
			} else if (b < nums[i]){
				b = nums[i];
			}
		}
		return (a-1)*(b-1);
	}

}
