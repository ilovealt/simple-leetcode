package com.ilovealt.leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *     选择排序
 * </p>
 *
 * @author wangs
 * @since 2021/12/3 9:37
 */
public class SelectionSort {

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
		SelectionSort ss = new SelectionSort();
		int[] old = newIntArray();
		System.out.println(Arrays.toString(old));

		int[] ss1 = old.clone();
		ss.selectionSort_1(ss1);
		System.out.println(Arrays.toString(ss1));
	}

	private void selectionSort_1(int[] nums) {
		int n = nums.length;
		if (n <= 1) {
			return;
		}
		for (int i = 0; i < n; i++) {
			//最小值变量
			int min = nums[i];
			//最小值索引
			int index = i;
			//找到最小
			for (int j = i+1; j < n; j++) {
				//有更小值，替换值并记录索引
				if (nums[j] < min) {
					min = nums[j];
					index = j;
				}
			}
			//交换
			swap(nums, i, index);
		}
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
