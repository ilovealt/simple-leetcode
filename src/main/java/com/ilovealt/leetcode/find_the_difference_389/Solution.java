package com.ilovealt.leetcode.find_the_difference_389;

import java.util.Arrays;

/**
 * 数据范围：0 <= s.length <= 1000; t.length == s.length + 1;s 和 t 只包含小写字母;
 * 总结：
 */
public class Solution {

	/**
	 *  类型：排序
	 *  解题思路：
	 *  时间复杂度：
	 *  空间复杂度:
	 */
	public char findTheDifference(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		//排序 可以使用自己写排序算法
		Arrays.sort(sc);
		Arrays.sort(tc);
		for (int i = 0; i < sc.length; i++) {
			if (tc[i] != sc[i]) {
				return tc[i];
			}
		}
		return tc[tc.length-1];
	}

	/**
	 * 求和
	 * 差值为添加字符
	 */
	public char findTheDifference1(String s, String t) {
		int ss=0,ts=0;
		for (int i = 0; i < s.length(); i++) {
			ss += s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			ts += t.charAt(i);
		}
		return (char) (ts - ss);
	}

	/**
	 * 位运算 异或
	 * 相同的归0，不同的留下来
	 */
	public char findTheDifference2(String s, String t) {
		int xor = 0;
		for (int i = 0; i < s.length(); i++) {
			xor ^= s.charAt(i);
		}
		for (int i = 0; i < t.length(); i++) {
			xor ^= t.charAt(i);
		}
		return (char) xor;
	}

}
