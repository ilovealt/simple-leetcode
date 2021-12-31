package com.ilovealt.leetcode.best_time_to_buy_and_sell_stock_121;

/**
 * 数据范围：1 <= prices.length <= 10^5; 0 <= prices[i] <= 10^4;
 * 总结：
 */
public class Solution {

	/**
	 *  类型：排序
	 *  解题思路：
	 *  时间复杂度：
	 *  空间复杂度:
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
	}

	/**
	 *  类型：暴力遍历方法
	 *  解题思路：
	 *  时间复杂度：O(n^2)
	 *  空间复杂度: O(1)
	 */
	public int maxProfit(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length-1; i++) {
			for (int j = i+1; j < prices.length; j++) {
				int price = prices[j] - prices[i];
				if (price > max) {
					max = price;
				}
			}
		}
		return max;
	}

	/**
	 *  类型：找最大差值
	 *  解题思路：
	 *  时间复杂度：O(n^2)
	 *  空间复杂度: O(1)
	 */
	public int maxProfit_1(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]-minPrice);
		}
		return maxProfit;
	}

}
