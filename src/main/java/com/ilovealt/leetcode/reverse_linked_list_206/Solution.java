package com.ilovealt.leetcode.reverse_linked_list_206;

/**
 数据范围、前提条件和边界条件： 数据范围 0-5000；
 解题思路：
 第一种： 迭代 直接反转指针，涉及三个变量 前一个、当前、下一个；
        时间复杂度：O(n)  空间复杂度：O(1)
 第二种：递归 深度优先算法；1.添加终止条件；2.递归语句；3.逻辑处理；
        时间复杂度：O(n)  空间复杂度：O(n)
 */
public class Solution {

    /**
     * 迭代
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr  = head;
        while (curr != null) {
            ListNode next = curr.next;
            //反转，把指针指向前一个
            curr.next = prev;
            //相当于向后移动 当前变为前一个，下一个变为当前；
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 递归 深度优先算法
     */
    public ListNode reverseList1(ListNode head) {
        //1.终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //2.深度遍历
        ListNode newHead = reverseList1(head.next);
        //3.逻辑处理
        head.next.next = head;
        head.next = null;
        //返回值
        return newHead;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}