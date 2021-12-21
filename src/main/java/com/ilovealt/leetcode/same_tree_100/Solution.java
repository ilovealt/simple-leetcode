package com.ilovealt.leetcode.same_tree_100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数据范围：两棵树上的节点数目都在范围 [0, 100] 内；-10^4 <= Node.val <= 10^4;
 * 时间复杂度：O(min(m,n))
 * 空间复杂度：O(min(m,n))
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
	}

	//自己 深度优先搜索
	public boolean isSameTree(TreeNode p, TreeNode q) {
		//终止条件
		if(p == null && q == null) {
			return true;
		}
		//逻辑处理
		if(p != null && q != null) {
			boolean flag = true;
			if (p.val != q.val) {
				flag = false;
			}
			flag = flag & isSameTree(p.left, q.left);
			flag = flag & isSameTree(p.right, q.right);
			return flag;

		}
		return false;
	}

	//官网代码简洁 深度优先搜索
	public boolean isSameTree_1(TreeNode p, TreeNode q) {
		//终止条件
		if(p == null && q == null) {
			return true;
		} else if (p == null || q == null){
			return false;
		} else if (p.val != q.val) {
			return false;
		} else {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
	}

	/**
	 * 官网代码简洁 广度优先搜索
	 * 特点 使用Queue存放节点，并逐个取出，然后把未完成再放入队列，如此循环，直到结束；
	 * 时间复杂度：O(min(m,n))
	 * 空间复杂度：O(min(m,n))
	 */
	public boolean isSameTree_2(TreeNode p, TreeNode q) {
		if(p == null && q == null) {
			return true;
		} else if (p == null || q == null){
			return false;
		}
		//
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(p);
		queue2.offer(q);

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (node1.val != node2.val) {
				return false;
			}
			//
			TreeNode left1 = node1.left,right1 = node1.right,left2 = node2.left,right2 = node2.right;
			if (left1 == null ^ left2 == null) {
				return false;
			}
			if (right1 == null ^ right2 == null) {
				return false;
			}
			if (left1 != null) {
				queue1.offer(left1);
			}
			if (right1 != null) {
				queue1.offer(right1);
			}
			if (left2 != null) {
				queue2.offer(left2);
			}
			if (right2 != null) {
				queue2.offer(right2);
			}
		}
		return queue1.isEmpty() && queue2.isEmpty();
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