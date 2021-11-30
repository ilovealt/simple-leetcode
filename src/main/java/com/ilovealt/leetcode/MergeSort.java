package com.ilovealt.leetcode;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] nums = new int[]{3, 0 ,1};
		mergeSort.mergeSort(nums);
		System.out.println(" end " + Arrays.toString(nums));
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
		int mid = (start + end) / 2;
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
		System.out.println(Arrays.toString(nums));
	}

}
