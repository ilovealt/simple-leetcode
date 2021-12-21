package com.ilovealt.leetcode.maximum_depth_of_binary_tree_104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据范围：
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
	 *  类型：深度优先遍历
	 *  解题思路：
	 *  时间复杂度：O(n)
	 *  空间复杂度: O(height)
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int depth = 1;
		depth += deep(root.left, root.right);
		return depth;
	}

	public int deep(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return 0;
		}
		//当前深度
		int depth = 1;
		//左子树深度
		int leftDepth = 0;
		if (left != null) {
			leftDepth += deep(left.left, left.right);
		}
		//右子树深度
		int rightDepth = 0;
		if (right != null) {
			rightDepth = deep(right.left, right.right);
		}

		depth += Math.max(leftDepth, rightDepth);
		return depth;
	}

	//官方解法 代码太简洁了
	public int maxDepth_1(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = maxDepth(root.left);
			int rightHeight = maxDepth(root.right);
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	/**
	 * 广度优先搜索
	 */
	public int maxDepth_2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int ans = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
			}
			ans++;
		}
		return ans;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}