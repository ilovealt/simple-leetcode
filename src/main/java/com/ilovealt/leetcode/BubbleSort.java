package com.ilovealt.leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *     冒泡排序
 * </p>
 *
 * @author wangs
 * @since 2021/12/3 7:44
 */
public class BubbleSort {

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
		BubbleSort bs = new BubbleSort();
		int[] old = newIntArray();
		System.out.println(Arrays.toString(old));

		int[] bs1 = old.clone();
		bs.bubbleSort_1(bs1);
		System.out.println(Arrays.toString(bs1));

		int[] bs2 = old.clone();
		bs.bubbleSort_2(bs2);
		System.out.println(Arrays.toString(bs2));

		int[] bs3 = old.clone();
		bs.bubbleSort_3(bs3);
		System.out.println(Arrays.toString(bs3));

		int[] bs4 = old.clone();
		bs.bubbleSort_4(bs4);
		System.out.println(Arrays.toString(bs4));
	}

	/**
	 * 第一层 从小到大；第二层 从小到大；
	 * @param nums 数组
	 */
	private void bubbleSort_1(int[] nums) {
		int n = nums.length;
		if (n <= 1) { return; }
		//第一层 从小到大
		for (int i = 0; i < n; i++) {
			//第二层  从小到大, 结尾处 n-1是为了j+1不溢出，
			// -i是因为数组末尾的已经有序，不需要在进行比较
			for (int j = 0; j < n-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
				}
			}
		}
	}

	/**
	 * 优化
	 * 第一层 从小到大；第二层 从小到大；有提前结束标志；
	 * @param nums 数组
	 */
	private void bubbleSort_2(int[] nums) {
		int n = nums.length;
		if (n <= 1) { return; }
		//是否发生替换动作
		boolean flag;
		//第一层 从小到大
		for (int i = 0; i < n; i++) {
			flag = false;
			//第二层  从小到大, 结尾处 n-1是为了j+1不溢出，
			// -i是因为数组末尾的已经有序，不需要在进行比较
			for (int j = 0; j < n-1-i; j++) {
				if (nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
					flag = true;
				}
			}
			//提前结束
			if (!flag) { break; }
		}
	}

	/**
	 * 这种从底下往上，更像是冒泡
	 * 与1，2，4方法思路相反
	 * 第一层 从大到小；第二层 从大到小；
	 * 注意：可以添加像bubbleSort_2提前结束标志，这里不重复实现；
	 * @param nums 数组
	 */
	private void bubbleSort_3(int[] nums) {
		int n = nums.length;
		if (n <= 1) { return; }
		//第一层 从大到小
		for (int i = n-1; i >= 0; i--) {
			//第二层  从大到小
			//头部变有序，重点处理后面
			//n-1是索引范围，n-2=n-1-1,多-1是防止j+1越界；n-1-i把头部有序范围排序
			for (int j = n-2; j >= n-1-i; j--) {
				if (nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
				}
			}
		}
	}

	/**
	 * 同1，2思路相同 大的沉底
	 */
	private void bubbleSort_4(int[] nums) {
		int n = nums.length;
		if (n <= 1) { return; }
		//第一层 从小到大
		for (int i = 0; i < nums.length; i++) {
			//第二层 从大到小
			for (int j = i-1; j >= 0 ; j--) {
				if (nums[j] > nums[j+1]) {
					swap(nums, j, j+1);
				}
			}
		}
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
