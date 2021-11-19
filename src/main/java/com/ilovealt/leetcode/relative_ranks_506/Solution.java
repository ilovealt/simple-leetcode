package com.ilovealt.leetcode.relative_ranks_506;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 数据范围：N 是一个正整数并且不会超过 10000;所有运动员的成绩都不相同;
 * 前提条件：
 * 边界条件：
 * 总结：读题不仔细，实际思路没有很难；
 */
public class Solution {

	/**
	 *  排序 优先队列
	 *  解题思路：先数据排序；缓存分数和索引；再遍历队列取数；
	 *  时间复杂度：O(nlogn) 优先队列的时间复杂度
	 *  空间复杂度: O(n)
	 */
	public String[] findRelativeRanks(int[] score) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		Map<Integer, Integer> map = new HashMap<>(score.length);
		for (int i = 0; i < score.length; i++) {
			Integer value = score[i];
			queue.add(value);
			map.put(value, i);
		}

		String[] ss = new String[queue.size()];
		for (int i = 0; i < ss.length; i++) {
			int index = map.get(queue.poll());
			switch(i) {
				case 0: ss[index] = "Gold Medal";
					break;
				case 1: ss[index] = "Silver Medal";
					break;
				case 2: ss[index] = "Bronze Medal";
					break;
				default: ss[index] = String.valueOf(i + 1);
			}
		}
		return ss;
	}

}
