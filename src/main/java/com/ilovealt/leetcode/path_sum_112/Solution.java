package com.ilovealt.leetcode.path_sum_112;

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
	 *  类型：广度优先搜索 记录根节点到当前节点路径和，以防止重复计算；
	 *  解题思路：
	 *  时间复杂度：O(N)
	 *  空间复杂度: O(N)
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		//两个队列，分别存储原始节点，以后路径和
		Queue<TreeNode> queNode = new LinkedList<>();
		Queue<Integer> queVal = new LinkedList<>();
		queNode.offer(root);
		queVal.offer(root.val);
		//
		while (!queNode.isEmpty()) {
			TreeNode treeNode = queNode.poll();
			int treeVal = queVal.poll();
			if (treeNode.left == null && treeNode.right == null) {
				if (treeVal == sum) {
					return true;
				}
				continue;
			}
			//左
			if (treeNode.left != null) {
				queNode.offer(treeNode.left);
				queVal.offer(treeNode.left.val + treeVal);
			}
			//右
			if (treeNode.right != null) {
				queNode.offer(treeNode.right);
				queVal.offer(treeNode.right.val + treeVal);
			}
		}
		return false;
	}

	/**
	 *  类型：递归
	 *  解题思路：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val
	 *  时间复杂度：O(N)
	 *  空间复杂度: O(logN)
	 */
	public boolean hasPathSum_1(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return root.val == sum;
		}
		return hasPathSum_1(root.left, sum- root.val) || hasPathSum_1(root.right, sum- root.val);
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
