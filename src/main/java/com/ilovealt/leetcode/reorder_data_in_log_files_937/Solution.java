package com.ilovealt.leetcode.reorder_data_in_log_files_937;

import com.ilovealt.leetcode.Tool;

import java.util.Arrays;

/**
 * 数据范围：1 <= logs.length <= 100；3 <= logs[i].length <= 100；
 */
public class Solution {

	/**
	 *  类型：日志排序
	 *  解题思路：
	 *  时间复杂度：都为数字日志 O(n)；都为字母日志 O(nlogn)；
	 *  空间复杂度: O(1)
	 *   总结：
	 */
	public static void main(String[] args) {
		//int[] array = Tool.newArrayLength20();
	}


	/**
	 * 整体分两步走：
	 * 		第一步 数字日志和字母日志的排序；
	 * 		第二步 字母日志的排序
	 */
	public String[] reorderLogFiles(String[] logs) {
		int lastIndex = sortNumber(logs);
		//如果 < 0 说明排序完成了
		if (lastIndex-1 < 0) {
			return logs;
		}
		//处理字母日志
		Arrays.sort(logs, 0, lastIndex, this::logCompare);
		return logs;
	}

	/**
	 * 对比方法 字母日志
	 */
	public int logCompare(String str1, String str2) {
		String[] split1 = str1.split(" ", 2);
		String[] split2 = str2.split(" ", 2);
		//对比
		int sc = split1[1].compareTo(split2[1]);
		if (sc != 0) {
			return sc;
		}
		return split1[0].compareTo(split2[0]);
	}


	/**
	 * 排序后，获得字母日志最后位置
	 */
	private int sortNumber(String[] logs) {
		int n = logs.length - 1;
		int numIndex = logs.length;
		//倒排
		for (int i = n; i >= 0; i--) {
			String str = logs[i];
			//遇到数字日志向后移动
			if (isNumber(str)) {
				//交换数据
				Tool.swap(logs, i, --numIndex);
			}
		}
		return numIndex;
	}

	/**
	 * 判断是不是数字日志
	 */
	private boolean isNumber(String str) {
		String[] split = str.split(" ", 2);
		return Character.isDigit(split[1].charAt(0));
	}

}
