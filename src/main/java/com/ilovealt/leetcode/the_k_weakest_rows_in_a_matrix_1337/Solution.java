package com.ilovealt.leetcode.the_k_weakest_rows_in_a_matrix_1337;

import java.util.Arrays;

/**
 * 数据范围：matrix[i][j] 不是 0 就是 1;2 <= n, m <= 100;
 * 总结：
 */
public class Solution {

	/**
	 *  排序
	 *  解题思路：行数组求和结果存于数组A中，对应索引存于数组B中；
	 *           对数组A排序，交换数据时，同时调整数组B中数据；
	 *           完成后数组B中是所有索引排好序的结果，截取k个；
	 *  时间复杂度：n=mat.length，遍历n，冒泡n方，截取n，所以 时间复杂度O(n平方)；
	 *  空间复杂度:两个数据空间 mat.length，
	 */
	public int[] kWeakestRows(int[][] mat, int k) {
		int[] hang = new int[mat.length];
		int[] index = new int[mat.length];
		for (int i = 0; i < mat.length; i++) {
			//可以优化，使用现存方法效率低
			int sum = Arrays.stream(mat[i]).sum();
			hang[i] = sum;
			index[i] = i;
		}

		//冒泡
		for (int i = 0; i < hang.length; i++) {
			for (int j = hang.length -1; j > i; j--) {
				if (hang[j] < hang[j-1]) {
					swap(hang, index, j, j-1);
				}
			}
		}

		return Arrays.copyOfRange(index, 0, k);
	}

	private void swap(int[] source, int[] index, int i, int j) {
		//数据
		int temp = source[i];
		source[i] = source[j];
		source[j] = temp;
		//索引
		int temp1 = index[i];
		index[i] = index[j];
		index[j] = temp1;
	}

}
