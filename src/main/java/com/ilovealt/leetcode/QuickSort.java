package com.ilovealt.leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 快排
 */
public class QuickSort {

	private static int[] newIntArray() {
		int length = 20;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int[] numbs = new int[length];
		for (int i = 0; i < length; i++) {
			numbs[i] = random.nextInt(10000);
		}
		return numbs;
	}

	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] old = newIntArray();
		System.out.println(Arrays.toString(old));

		int[] bs1 = old.clone();
		quickSort.quickSort(bs1);
		System.out.println(Arrays.toString(bs1));
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
		if (start == end) {
			return;
		}
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

}
