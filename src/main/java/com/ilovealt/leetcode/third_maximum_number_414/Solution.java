package com.ilovealt.leetcode.third_maximum_number_414;

/**
 * 数据范围：非空数组; 数值大小范围为整数；
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		int[] nums = new int[]{2,2,3,1};
		int i = thirdMax(nums);
		System.out.println(i);
	}
	/**
	 *  类型：排序
	 *  解题思路：
	 *  时间复杂度：
	 *  空间复杂度:
	 */
	public static int thirdMax(int[] nums) {
		//a b c 从大到小
		long a = Long.MIN_VALUE,b = Long.MIN_VALUE,c = Long.MIN_VALUE;
		for (int num : nums) {
			if (num > a) {
				c = b;
				b = a;
				a = num;
			} else if (a > num && num > b) {
				c = b;
				b = num;
			} else if (b > num && num > c) {
				c = num;
			}
		}

		//其实这里很巧妙 如果数据个数<=2，直接返回最大值
		return c == Long.MIN_VALUE ? (int)a : (int)c;
	}

}
