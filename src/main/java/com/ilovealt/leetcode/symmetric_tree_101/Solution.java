package com.ilovealt.leetcode.symmetric_tree_101;

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

	public boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}

	//深度优先搜索
	public boolean check(TreeNode p, TreeNode q) {
		//终止条件
		if(p == null && q == null) {
			return true;
		} else if (p == null || q == null){
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			//与 100 题不同的地方
			return check(p.left, q.right) && check(p.right, q.left);
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