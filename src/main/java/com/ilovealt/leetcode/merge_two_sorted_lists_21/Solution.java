package com.ilovealt.leetcode.merge_two_sorted_lists_21;

/**
 数据范围、前提条件和边界条件： 节点数目范围是 [0, 50]；-100 <= Node.val <= 100；l1和l2均按非递减顺序排列；
 解题思路：
 第一种：两个链两个指针，向下遍历，两个指针所在值进行对比；
 第二种：递归
 时间空间复杂度分析： O(m+n)
 总结：迭代的方式，代码实现能力不足；递归方式没有想到；
 */
public class Solution {

    /**
     * 迭代 定义好头节点
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        //主要迭代
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            //这个指针也需要随着l1或者l2指针向后增加而增加
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * 递归
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        else if (l2 == null) { return l1; }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}

/**
 * 节点
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}