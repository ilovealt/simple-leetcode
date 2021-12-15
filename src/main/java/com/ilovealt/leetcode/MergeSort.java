package com.ilovealt.leetcode;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 归并排序
 */
public class MergeSort {

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
		MergeSort mergeSort = new MergeSort();
		int[] old = newIntArray();
		System.out.println(Arrays.toString(old));

		int[] bs1 = old.clone();
		mergeSort.mergeSort(bs1);
		System.out.println(Arrays.toString(bs1));

		int[] bs2 = old.clone();
		mergeSort.mergeSort_1(bs2);
		System.out.println(Arrays.toString(bs2));
	}

	public void mergeSort(int[] nums) {
		mergeSortC(nums, 0, nums.length-1);
	}

	/**
	 * 递归调用 分治
	 * 技巧：先提取递推公式；找到终止条件；转换为代码；
	 */
	public void mergeSortC(int[] nums, int start, int end) {
		//终止条件
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		mergeSortC(nums, start, mid);
		mergeSortC(nums, mid+1, end);
		//归并
		merge(nums, start, mid, end);
	}

	/**
	 * 归并
	 * 把前面分治的数据，归并处理
	 */
	public void merge(int[] nums, int start, int mid, int end) {
		//双指针 标记原数组
		int i = start, j = mid + 1;
		//新创建数组的索引
		int k = 0;
		int[] temp = new int[end-start+1];
		//遍历后 把未结束的指针走到头
		while (i <= mid && j <= end) {
			if (nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		//判断哪个没走到终点
		int m = i, n = mid;
		if (j <= end) {
			m = j;
			n = end;
		}

		while (m <= n) {
			temp[k++] = nums[m++];
		}
		//将temp复制回nums
		for (int l = 0; l < end-start+1; l++) {
			nums[start+l] = temp[l];
		}
	}

	private int[] aux;
	public void mergeSort_1(int[] nums) {
		aux = new int[nums.length];
		mergeSortC_1(nums, 0, nums.length-1);
	}

	/**
	 * 递归调用 分治
	 * 技巧：先提取递推公式；找到终止条件；转换为代码；
	 */
	public void mergeSortC_1(int[] nums, int start, int end) {
		//终止条件
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;
		mergeSortC_1(nums, start, mid);
		mergeSortC_1(nums, mid+1, end);
		//归并
		merge_1(nums, start, mid, end);
	}

	/**
	 * 归并
	 * 把前面分治的数据，归并处理
	 * 这中方式是“算法”数中得解法
	 */
	public void merge_1(int[] nums, int start, int mid, int end) {
		//双指针 标记原数组
		int i = start, j = mid + 1;
		//把原值复制到新数组中
		for (int k = start; k <= end ; k++) {
			aux[k] = nums[k];
		}
		//将temp复制回nums并排序
		for (int k = start; k <= end ; k++) {
			if (i > mid) { nums[k] = aux[j++]; }
			else if (j > end) { nums[k] = aux[i++]; }
			else if (aux[i] > aux[j]) { nums[k] = aux[j++]; }
			else { nums[k] = aux[i++]; }
		}
	}
}
