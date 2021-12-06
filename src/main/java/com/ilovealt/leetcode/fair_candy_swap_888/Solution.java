package com.ilovealt.leetcode.fair_candy_swap_888;

import java.util.HashSet;
import java.util.Set;

/**
 * 数据范围：
 * 总结：
 */
public class Solution {

	/**
	 *  类型：排序
	 *  解题思路：一个数据放到set中
	 *  时间复杂度：
	 *  空间复杂度:
	 */
	public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		int aliceSum = 0;
		for (int alice : aliceSizes) {
			aliceSum += alice;
		}

		int bobSum = 0;
		Set<Integer> bobSet = new HashSet<>(bobSizes.length);
		for (int bob : bobSizes) {
			bobSet.add(bob);
			bobSum += bob;
		}

		//总和差  可能存在负数，但是 可以使用（aliceSum - sumCha）消除
		int sumCha = (aliceSum - bobSum) / 2;
		int[] result = new int[] {0,0};
		for (int alice : aliceSizes) {
			if(bobSet.contains(alice - sumCha)) {
				result[0] = alice;
				result[1] = alice - sumCha;
			}
		}

		return result;
	}

}
