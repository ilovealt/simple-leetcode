package com.ilovealt.leetcode.swap_nodes_in_pairs_24;

/**
 * 数据范围：链表中节点的数目在范围 [0, 100] 内； 0 <= Node.val <= 100；
 * 总结：
 */
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[]{4,3,2,7,8,2,3,1};
	}

	/**
	 * 递归
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}

	/**
	 * 迭代
	 */
	public ListNode swapPairs_1(ListNode head) {
		//头指针节点，建立连接
		ListNode pre = new ListNode(0);
		pre.next = head;
		//处理两两交换
		ListNode temp = pre;
		while (temp.next != null &&  temp.next.next != null) {
			ListNode cur = temp.next;
			ListNode next = temp.next.next;
			//指针调换 设计三个指针调整，缺一不可，否则链断
			cur.next = next.next;
			next.next = cur;
			temp.next = next;
			//下一对
			temp = cur;
		}
		//结果
		return pre.next;
	}


}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode() {}
	 ListNode(int val) { this.val = val; }
	 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}