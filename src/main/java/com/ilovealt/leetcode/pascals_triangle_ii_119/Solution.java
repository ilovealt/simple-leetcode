package com.ilovealt.leetcode.pascals_triangle_ii_119;

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
		List<Integer> row = solution.getRow(3);
		System.out.println(row);
		List<Integer> row1 = solution.getRow_1(3);
		System.out.println(row1);
	}

	public List<Integer> getRow(int rowIndex) {
		//构建杨辉三角图形
		int size = rowIndex+1;
		List<List<Integer>> listTriangle = new ArrayList<>(size);
		//初始化
		for (int i = 0; i < size; i++) {
			listTriangle.add(fillingRow(size, i));
		}
		//补全
		for (int i = 2; i < size; i++) {
			List<Integer> upList = listTriangle.get(i - 1);
			System.out.println("upList : " + upList);
			List<Integer> list = listTriangle.get(i);
			System.out.println("list : " + list);
			computeRow(upList, list);
		}
		//获取
		List<Integer> list = listTriangle.get(rowIndex);
		List<Integer> list1 = list.subList(0, size);
		return list1;
	}

	/**
	 * 填充
	 */
	private List<Integer> fillingRow(int size, int index) {
		List<Integer> list = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			if (i == 0 || i == index) {
				list.add(1);
			} else {
				list.add(0);
			}
		}
		return list;
	}

	/**
	 * 计算数据并填充
	 */
	private void computeRow(List<Integer> upList, List<Integer> currentList) {
		for (int i = 1; i < currentList.size(); i++) {
			Integer a = upList.get(i - 1);
			Integer b = upList.get(i);
			currentList.set(i, a+b);
		}
	}


	public List<Integer> getRow_1(int rowIndex) {
		//构建杨辉三角图形
		int size = rowIndex+1;
		int[][] triangle = new int[size][size];
		//初始化
		for (int i = 0; i < size; i++) {
			triangle[i][0] = 1;
			triangle[i][i] = 1;
		}
		//补全
		for (int i = 1; i < size; i++) {
			int[] up = triangle[i - 1];
			int[] cur = triangle[i];
			for (int j = 1; j < size; j++) {
				cur[j] = up[j-1] + up[j];
			}
		}
		//获取 不用Stream方式
		List<Integer> result = new ArrayList<>(size);
		for (int num : triangle[rowIndex]) {
			result.add(num);
		}
		return result;
	}


}
