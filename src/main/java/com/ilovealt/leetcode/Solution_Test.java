package com.ilovealt.leetcode;

import java.util.Arrays;

/**
 * 数据范围：
 */
public class Solution_Test {

	/**
	 *  类型：排序
	 *  解题思路：
	 *  时间复杂度：
	 *  空间复杂度:
	 *   总结：
	 */
	public static void main(String[] args) {
		System.out.println("========================Bubble==========================");
		Bubble bubble = new Bubble();
		int[] baoLi = bubble.baoLi();
		System.out.println(Arrays.toString(baoLi));
		int[] shang2Xia = bubble.shang2Xia();
		System.out.println(Arrays.toString(shang2Xia));
		int[] shang2Xia_flag = bubble.shang2Xia_flag();
		System.out.println(Arrays.toString(shang2Xia_flag));
		int[] xia2Shang = bubble.xia2Shang();
		System.out.println(Arrays.toString(xia2Shang));
		System.out.println("========================Insert==========================");
		Insert insert = new Insert();
		int[] insertOnlyOne = insert.onlyOne();
		System.out.println(Arrays.toString(insertOnlyOne));
		System.out.println("========================Selection==========================");
		Selection selection = new Selection();
		int[] selectMin = selection.selectMin();
		System.out.println(Arrays.toString(selectMin));
		System.out.println("========================Merge==========================");
		Merge merge = new Merge();
		int[] mergeSort = merge.mergeTest();
		System.out.println(Arrays.toString(mergeSort));
		System.out.println("========================Quick==========================");
		Quick quick = new Quick();
		int[] quickSort = quick.quickTest();
		System.out.println(Arrays.toString(quickSort));
	}

	/**
	 * 冒泡算法：你想到了什么？
	 * 排序：暴力求解；从上向下沉；从下向上冒；
	 * 时间复杂度：都是 O(N^2)
	 * 空间复杂度：三种方法都是直接在原数组上操作，因此空间复杂度为 O(1)
	 */
	public static class Bubble {

		/**
		 * 暴力求解
		 */
		public int[] baoLi() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			for (int i = 0; i < length-1; i++) {
				for (int j = i+1; j < length; j++) {
					if (nums[i] > nums[j]) {
						Tool.swap(nums, i, j);
					}
				}
			}
			return nums;
		}

		/**
		 * 从上向下沉
		 */
		public int[] shang2Xia() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			for (int i = 0; i < length; i++) {
				//length-i-1 这个是为了j+1不溢出
				for (int j = 0; j < length-i-1; j++) {
					if (nums[j] > nums[j+1]) {
						Tool.swap(nums, j, j+1);
					}
				}
			}
			return nums;
		}

		/**
		 * 从上向下沉，添加提前结束标记
		 */
		public int[] shang2Xia_flag() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			//标记：是否交换位置
			boolean change;
			for (int i = 0; i < length; i++) {
				change = false;
				//length-i-1 这个是为了j+1不溢出
				for (int j = 0; j < length-i-1; j++) {
					if (nums[j] > nums[j+1]) {
						change = true;
						Tool.swap(nums, j, j+1);
					}
				}
				//如果遍历一遍以后没有位置交换，说明已经有序，不需要再遍历
				if (!change) {
					break;
				}
			}
			return nums;
		}

		/**
		 * 从下向上冒
		 */
		public int[] xia2Shang() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			for (int i = length-1; i >= 0 ; i--) {
				for (int j = length-2; j >= length-i-1; j--) {
					if (nums[j] > nums[j+1]) {
						Tool.swap(nums, j, j+1);
					}
				}
			}
			return nums;
		}

	}


	/**
	 * 插入排序算法：你想到了什么？
	 * 排序： 双层遍历，把大的后移；中间有顺序的直接跳过
	 * 时间复杂度：O(N^2)
	 * 空间复杂度：O(1)
	 */
	public static class Insert {

		/**
		 * 双层遍历，把大的后移；中间有顺序的直接跳过
		 */
		public int[] onlyOne() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			for (int i = 1; i < length; i++) {
				int value = nums[i];
				int j = i-1;
				for (; j >= 0; j--) {
					if (nums[j] > value) {
						nums[j+1] = nums[j];
					} else {
						break;
					}
				}
				//把比较的这个值，放会数组
				nums[j+1] = value;
			}
			return nums;
		}

	}

	/**
	 * 选择排序算法：你想到了什么？
	 * 排序： 从头开始遍历，设一个最小值，遍历后面找到最小值，重复此过程；
	 * 时间复杂度：O(N^2)
	 * 空间复杂度：O(1)
	 */
	public static class Selection {

		/**
		 * 设一个最小值，遍历后面找到最小值
		 */
		public int[] selectMin() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			for (int i = 0; i < length; i++) {
				int minIndex = i;
				int minValue = nums[i];
				for (int j = i+1; j < length; j++) {
					if (nums[j] < minValue) {
						minIndex = j;
						minValue = nums[j];
					}
				}
				//交换
				Tool.swap(nums, i, minIndex);
			}
			return nums;
		}

	}

	/**
	 * 归并排序算法：你想到了什么？
	 * 排序：
	 * 时间复杂度：
	 * 空间复杂度：
	 */
	public static class Merge {

		public int[] mergeTest() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			mergeSort(nums, 0, length-1);
			return nums;
		}

		/**
		 * 用递归拆分的差不多了，可以开始真正的排序合并数据了
		 * 归并数据
		 */
		private void mergeSort(int[] nums, int start, int end) {
			if (start >= end) return;
			int mid = start + (end - start) / 2;
			mergeSort(nums, start, mid);
			mergeSort(nums, mid+1, end);
			//归并
			merge(nums, start, mid, end);
		}

		private void merge(int[] nums, int start, int mid, int end) {
			//1.当前索引内的数字排序
			int i = start, j = mid + 1;
			//临时数组和索引
			int k = 0;
			int[] temp = new int[end-start+1];
			//两边数据分别对比，并按序存入临时数组
			while (i <= mid && j <= end) {
				if (nums[i] <= nums[j]) {
					temp[k++] = nums[i++];
				} else {
					temp[k++] = nums[j++];
				}
			}
			//2.把未走完的索引走完，保证此区级所有数据排好序
			int m = i, n = mid;
			if (j <= end) {
				m = j;
				n = end;
			}
			//剩余数据直接放入临时数组
			while (m <= n) {
				temp[k++] = nums[m++];
			}
			//3.把新的有序数据放回原数组
			for (int l = 0; l < end-start+1; l++) {
				nums[start+l] = temp[l];
			}
		}

	}

	/**
	 * 快速排序算法：你想到了什么？
	 * 排序：
	 * 时间复杂度：
	 * 空间复杂度：
	 */
	public static class Quick {

		public int[] quickTest() {
			int[] nums = Tool.newArrayLength20();
			int length = nums.length;
			//算法
			quickSort(nums, 0, length-1);
			return nums;
		}

		private void quickSort(int[] nums, int start, int end) {
			if (start >= end) return;
			//排序
			int mid = partition(nums, start, end);
			//递归排序
			quickSort(nums, start, mid-1);
			quickSort(nums, mid+1, end);
		}

		private int partition(int[] nums, int start, int end) {
			//对比标准
			int pivot = nums[end];
			int i = start;
			for (int j = start; j < end; j++) {
				if (nums[j] < pivot) {
					//小于标准点的数据向前移动
					Tool.swap(nums, i, j);
					i++;
				}
			}
			//把标准值放到以它为分界中间位置
			Tool.swap(nums, i, end);
			return i;
		}


	}
}
