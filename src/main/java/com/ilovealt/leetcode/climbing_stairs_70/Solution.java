package com.ilovealt.leetcode.climbing_stairs_70;

/**
 * 数据范围：n阶楼梯；每次1到2个台阶；
 * 总结：
 */
public class Solution {

	/**
	 * 爬楼图
	 */
	public int climbStairs(int n) {
		int prev = 1,cur = 1;
		for (int i = 2; i < n+1; i++) {
			int temp = cur;
			cur = prev + cur;
			prev = temp;
		}
		return cur;
	}

}
