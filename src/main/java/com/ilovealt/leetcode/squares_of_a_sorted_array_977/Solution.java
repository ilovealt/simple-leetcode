package com.ilovealt.leetcode.squares_of_a_sorted_array_977;

import java.util.Arrays;

/**
 * 数据范围：1 <= nums.length <= 10^4; -10^4 <= nums[i] <= 10^4; nums已按非递减顺序排序;
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		//int[] nums = new int[]{-4,-1,0,3,10};
		int[] nums = new int[]{-7,-3,2,3,11};
		Solution solution = new Solution();
		int[] ints = solution.sortedSquares(nums);
		System.out.println(Arrays.toString(ints));
	}

	/**
	 *  类型：排序
	 *  解题思路：双指针，从两边向中间靠近；
	 *  时间复杂度：O(n) n为数组长度；
	 *  空间复杂度: O(1) 除了存储答案的空间；
	 */
	public int[] sortedSquares(int[] nums) {
		int length = nums.length;
		//新数组
		int newIndex = length-1;
		int[] newNum = new int[length];
		//从两边向中间靠近
		int ahead = 0;
		int back = length-1;
		//对比并填充数据, =号用于边界条件
		while (ahead <= back) {
			int before = nums[ahead] * nums[ahead];
			int after = nums[back] * nums[back];
			if (before > after) {
				newNum[newIndex--] = before;
				ahead++;
			} else {
				newNum[newIndex--] = after;
				back--;
			}
		}
		return newNum;
	}


}
