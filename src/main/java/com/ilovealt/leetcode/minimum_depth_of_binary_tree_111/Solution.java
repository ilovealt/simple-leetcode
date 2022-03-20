package com.ilovealt.leetcode.minimum_depth_of_binary_tree_111;

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
	}

	/**
	 * 深度优先搜索
	 */
	public int minDepth(TreeNode root) {
		if (root == null) { return 0; }
		else if(root.left == null) { return minDepth(root.right) + 1;}
		else if(root.right == null) { return minDepth(root.left) + 1;}
		else { return Math.min(minDepth(root.left), minDepth(root.right)) + 1;}
	}

	/**
	 * 广度优先搜索
	 */
	public int minDepth_1(TreeNode root) {
		if (root == null) {return 0;}
		Queue<QueueNode> queue = new LinkedList<>();
		queue.offer(new QueueNode(root, 1));
		while (!queue.isEmpty()) {
			QueueNode queueNode = queue.poll();
			TreeNode node = queueNode.node;
			int depth = queueNode.depth;
			if (node.left == null && node.right == null) {
				return depth;
			}
			if (node.left != null) {
				queue.offer(new QueueNode(node.left, depth+1));
			}
			if (node.right != null) {
				queue.offer(new QueueNode(node.right, depth+1));
			}
		}
		return 0;
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

class QueueNode {
	TreeNode node;
	int depth;

	public QueueNode(TreeNode node, int depth) {
		this.node = node;
		this.depth = depth;
	}
}
