package com.ilovealt.leetcode.missing_number_268;

import java.util.Arrays;

/**
 * 数据范围：n == nums.length;1 <= n <= 10^4;0 <= nums[i] <= n;nums 中的所有数字都 独一无二;
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = new int[]{3,0,1};
		System.out.println("================== " + solution.missingNumber(a));
		int[] b = new int[]{0,1};
		System.out.println("================== " + solution.missingNumber(b));
		int[] c = new int[]{9,6,4,2,3,5,7,0,1};
		System.out.println("================== " + solution.missingNumber(c));
		int[] d = new int[]{0};
		System.out.println("================== " + solution.missingNumber(d));
		int[] e = new int[]{1};
		System.out.println("================== " + solution.missingNumber(e));
	}

	/**
	 *  类型：排序
	 *  解题思路：使用排序方法得到有序数组，再依次遍历，相邻数据间差值大于1，则中间为丢失数据；
	 *  时间复杂度：
	 *  空间复杂度:
	 * @param nums 数组
	 * @return 缺少的数值
	 */
	public int missingNumber(int[] nums) {
		//这里可以使用多种排序方式：冒泡、选择、插入、归并、快排
		selectionSort(nums);
		int n = nums.length;
		for (int i = 0; i < n-1; i++) {
			if (nums[i+1] - nums[i] > 1) {
				return nums[i] +1;
			}
		}
		if (nums[0] != 0) { return 0; }
		if (nums[n-1] != n) { return n; }
		return 0;
	}

	/**
	 * 选择排序 不稳定
	 * 每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾
	 */
	private void selectionSort(int[] nums) {
		int n = nums.length;
		if (n <= 1) { return; }
		for (int i = 0; i < n; i++) {
			int min = nums[i];
			int index = i;
			for (int j = i+1; j < n; j++) {
				if (min > nums[j]) {
					min = nums[j];
					index = j;
				}
			}
			swap(nums, i, index);
		}
	}

	private void swap(int[] nums, int a, int b) {
		Arrays.sort(nums);
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}




	/**
	 * 位运算
	 * 添加 n+1个整数，则在2n+1个数中，前n个数中有一个缺失；
	 * 使用按位异或运算得到丢失的数字，对任意整数x都满足：x异或x=0 和 x异或0=x；
	 */
	public int missingNumber1(int[] nums) {
		int xor = 0;
		int n = nums.length;
		//前n个
		for (int i = 0; i < n; i++) {
			xor ^= nums[i];
		}
		//后n+1个
		for (int i = 0; i <= n; i++) {
			xor ^= i;
		}
		return xor;
	}
}
