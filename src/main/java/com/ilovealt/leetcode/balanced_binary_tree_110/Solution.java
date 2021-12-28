package com.ilovealt.leetcode.balanced_binary_tree_110;

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
	 *  类型：平衡二叉树
	 *  解题思路：自顶向下的递归
	 *  时间复杂度：O(n^2)
	 *  空间复杂度:O(n)
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(height(root.left), height(root.right)) + 1;
	}


	/**
	 *  类型：平衡二叉树
	 *  解题思路：自底向上的递归
	 *  时间复杂度：O(n)
	 *  空间复杂度:O(n)
	 */
	public boolean isBalanced_1(TreeNode root) {
		return height_1(root) >= 0;
	}

	private int height_1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height_1(root.left);
		int rightHeight = height_1(root.right);
		if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight-rightHeight) > 1) {
			return -1;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
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