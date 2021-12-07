package com.ilovealt.leetcode.sort_array_by_parity_ii_922;

import java.util.Arrays;

/**
 * 数据范围：2 <= A.length <= 20000; A.length % 2 == 0; 0 <= A[i] <= 1000;
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		//int[] nums = new int[]{1,4,4,3,0,3};
		int[] nums = new int[]{857,534,537,282,830,723};
		Solution test = new Solution();
		//int[] ints = test.sortArrayByParityII(nums);
		//int[] ints = test.sortArrayByParityII_1(nums);
		//int[] ints = test.sortArrayByParityII_2(nums);
		int[] ints = test.sortArrayByParityII_3(nums);
		System.out.println(Arrays.toString(ints));
	}

	//效率低
	public int[] sortArrayByParityII(int[] nums) {
		//先把排序
		Arrays.sort(nums);
		//遍历调整位置：奇数和偶数同时进行
		// 从头开始，偶数位定偶数，如果不是偶数向后找到第一个偶数，交换位置；
		//奇数类似方式
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i] % 2;
			int index = i % 2;
			if (index == 0 && num != 0) {
				int even = even(nums, i);
				swap(nums, i, even);
			} else if (index != 0 && num == 0){
				int odd = odd(nums, i);
				swap(nums, i, odd);
			}
		}
		return nums;
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

	private int even(int[] nums, int index) {
		for (int i = index+1; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				return i;
			}
		}
		return index;
	}

	private int odd(int[] nums, int index) {
		for (int i = index+1; i < nums.length; i++) {
			if (nums[i] % 2 != 0) {
				return i;
			}
		}
		return index;
	}


	//效率低
	public int[] sortArrayByParityII_1(int[] nums) {
		//先把排序
		Arrays.sort(nums);
		//遍历调整位置：奇数和偶数同时进行
		// 从头开始，偶数位定偶数，如果不是偶数向后找到第一个偶数，交换位置；
		//奇数类似方式
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			int num = nums[i] % 2;
			int index = i % 2;
			if (num != index) {
				int j = i+1;
				while (j < length) {
					if (nums[j]%2 != num) {
						break;
					}
					j++;
				}
				swap(nums, i, j);
			}
		}
		return nums;
	}

	/**
	 * 从头遍历；
	 * 创建两个指针，分别从末尾指向奇数和偶数；
	 */
	public int[] sortArrayByParityII_2(int[] nums) {
		int length = nums.length;
		//遍历
		for (int i = 0; i < length; i++) {
			int num = nums[i] % 2;
			int index = i % 2;
			if (index == 0 && num != 0) {
				int even = length-1;
				while (even >= i) {
					if (nums[even] % 2 == 0) {
						swap(nums, i, even);
						break;
					}
					even--;
				}
			} else if (index != 0 && num == 0){
				int odd = length-1;
				while (odd > i) {
					if (nums[odd] % 2 != 0) {
						swap(nums, i, odd);
						break;
					}
					odd--;
				}
			}
		}
		return nums;
	}

	/**
	 * 双层遍历：一个从头遍历，只处理偶数索引且数值为奇数的位置；一个从尾遍历，只查询奇数索引且数值为偶数；
	 */
	public int[] sortArrayByParityII_3(int[] nums) {
		int length = nums.length;
		//遍历
		int s = length-1;
		for (int i = 0; i < length; i++) {
			int num = nums[i] % 2;
			int index = i % 2;
			if (index == 0 && num != 0) {
				while (s >= 0) {
					if (s%2 !=0 && nums[s] % 2 == 0) {
						swap(nums, i, s);
						s--;
						break;
					}
					s--;
				}
			}
		}
		return nums;
	}

}
