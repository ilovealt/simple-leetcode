package com.ilovealt.leetcode.matrix_cells_in_distance_order_1030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据范围： 1 <= R <= 100; 1 <= C <= 100; 0 <= r0 < R; 0 <= c0 < C;
 * 总结：这类型问题第一次遇到，直接看答案开拓思路；
 */
public class Solution {

	/**
	 *  类型：直接排序
	 *  解题思路：
	 *  时间复杂度：O(rows×colslog(rows×cols))
	 *  空间复杂度:O(log(rows×cols))，即为排序需要使用的栈空间，不考虑返回值的空间占用。
	 */
	public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
		//记录值
		int[][] ret = new int[rows * cols][];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				ret[i*cols+j] = new int[]{i, j};
			}
		}
		//排序
		Arrays.sort(ret, (int[] o1, int[] o2) -> {
			int r = Math.abs(o1[0] - rCenter) + Math.abs(o1[1] - cCenter);
			int c = Math.abs(o2[0] - rCenter) + Math.abs(o2[1] - cCenter);
			return r-c;
		});
		return ret;
	}

	/**
	 *  类型：桶排序
	 *  解题思路：
	 *  时间复杂度：O(rows×cols)
	 *  空间复杂度: O(rows×cols)
	 */
	public int[][] allCellsDistOrder_1(int rows, int cols, int rCenter, int cCenter) {
		//创建桶，每一个桶创建一个位置
		int maxDist = Math.max(rCenter, rows-1-rCenter) + Math.max(cCenter, cols-1-cCenter);
		List<List<int[]>> bucket = new ArrayList<>();
		for (int i = 0; i <= maxDist; i++) {
			bucket.add(new ArrayList<>());
		}
		//遍历位置，把相同曼哈顿距离放入同一个桶中
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int d = dist(i, j, rCenter, cCenter);
				bucket.get(d).add(new int[]{i, j});
			}
		}
		//把桶中数据放入到新数组中，实现排序
		int[][] ret = new int[rows*cols][];
		int index = 0;
		for (int i = 0; i <= maxDist; i++) {
			for (int[] it : bucket.get(i)) {
				ret[index++] = it;
			}
		}
		//返回结果
		return ret;
	}

	/**
	 * 计算两点之间的曼哈顿距离
	 */
	private int dist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
