package com.ilovealt.leetcode.sort_array_by_parity_905;

import java.util.Arrays;

/**
 * 数据范围：1 <= A.length <= 5000; 0 <= A[i] <= 5000;
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{0,1,3};
		Solution solution = new Solution();
		solution.sortArrayByParity(nums);
		System.out.println(Arrays.toString(nums));
	}
	/**
	 *  类型：排序
	 *  解题思路：创建两个指针，第
	 *      一个从前往后把奇数移到后一个指针所在位置；
	 *      后一个指针向前移动，遇到偶数与前面指针交换数据
	 *      结束，两指针相遇的时候；
	 *  时间复杂度：O(n)
	 *  空间复杂度: O(1)
	 */
	public int[] sortArrayByParity(int[] nums) {
		int length = nums.length;
		int before = 0;
		int after = length-1;
		while (before < length && before < after) {
			//奇数
			if (nums[before]%2 != 0) {
				while (after >= 0 && before < after) {
					//偶数
					if (nums[after]%2 == 0) {
						swap(nums, before, after);
						break;
					}
					after--;
				}
			}
			before++;
		}
		return nums;
	}

	/**
	 * 替换
	 */
	public void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

}
