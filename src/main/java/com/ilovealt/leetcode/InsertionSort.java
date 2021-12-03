package com.ilovealt.leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *     插入算法
 * </p>
 *
 * @author wangs
 * @since 2021/12/3 8:14
 */
public class InsertionSort {

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
		InsertionSort is = new InsertionSort();
		int[] old = newIntArray();
		System.out.println(Arrays.toString(old));

		int[] is1 = old.clone();
		is.insertionSort_1(is1);
		System.out.println(Arrays.toString(is1));

	}

	private void insertionSort_1(int[] nums) {
		int n = nums.length;
		if (n <= 1) { return; }
		for (int i = 1; i < n; i++) {
			int value = nums[i];
			//比当前i索引小，意思向前遍历，到0结束
			int j = i -1;
			for (; j >= 0; j--) {
				//如果大于这个比较值，则往后移动，空出一个位置
				if (nums[j] > value) {
					nums[j+1] = nums[j];
				} else {
					break;
				}
			}
			//把比较值插入适当位置
			nums[j+1] = value;
		}
	}

}
