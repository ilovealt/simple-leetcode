package com.ilovealt.leetcode;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p> </p>
 *
 * @author wangs
 * @since 2022/2/7 7:37
 */
public final class Tool {

	public static int[] newArrayLength20() {
		return newArray(20);
	}

	public static int[] newArray(int length) {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		int[] numbs = new int[length];
		for (int i = 0; i < length; i++) {
			numbs[i] = random.nextInt(10000);
		}
		return numbs;
	}

	/**
	 * 替换
	 */
	public static void swap(int[] nums, int start, int end) {
		int temp = nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
	}

}
