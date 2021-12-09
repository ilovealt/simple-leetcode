package com.ilovealt.leetcode.find_all_numbers_disappeared_in_an_array_448;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p> </p>
 *
 * @author wangs
 * @since 2021/12/8 9:19
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
		List<Integer> strings = solution.findDisappearedNumbers(nums);
		System.out.println(strings);
		List<Integer> strings1 = solution.findDisappearedNumbers_1(nums);
		System.out.println(strings1);
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		int n = nums.length;
		//创建新数组，把已经存在的数据放入对应新数组位置
		//位置为0即为缺少的；
		int[] newNum = new int[n];
		for (int num : nums) {
			newNum[num-1] = -1;
		}
		//查找缺少
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < newNum.length; i++) {
			if (newNum[i] == 0) {
				list.add(i+1);
			}
		}

		return list;
	}

	/**
	 * 官网答案
	 * 我之前也是通过值更新对应索引位置数据，
	 * 但是我的解法存在无法保留原值信息的问题（把存在的值为-1）；
	 * 官网巧妙使用+n的形式，保存了原值，厉害；
	 */
	public List<Integer> findDisappearedNumbers_1(int[] nums) {
		int n = nums.length;
		for (int num : nums) {
			int x = (num - 1) % n;
			nums[x] += n;
		}
		//数组索引位置中数不大于n，说明对应数字存在，
		List<Integer> ret = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (nums[i] <= n) {
				ret.add(i + 1);
			}
		}
		return ret;
	}


}
