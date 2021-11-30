package com.ilovealt.leetcode;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] nums = new int[]{3, 0 ,1};
		quickSort.quickSort(nums);
		System.out.println(" end " + Arrays.toString(nums));
	}

	public void quickSort(int[] nums) {
		quickSortC(nums, 0, nums.length-1);
	}

	public void quickSortC(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}
		//获取分区点
		int mid = partition(nums, start, end);
		//端点 要避开 mid
		quickSortC(nums, start, mid-1);
		quickSortC(nums, mid+1, end);
	}

	/**
	 * 获取分区字段 所在索引值
	 */
	public int partition(int[] nums, int start, int end) {
		//对比标准
		int pivot = nums[end];
		//移动索引
		int i = start;
		for (int j = start; j < end; j++) {
			//把较小值替换到前面
			if (nums[j] < pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		//把pivot替换到中间位置
		swap(nums, i, end);
		return i;
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
