package com.ilovealt.leetcode.remove_duplicates_from_sorted_list_83;

/**
 数据范围、前提条件和边界条件：删除所有重复元素，每一个元素只出现一次；升序；
 解题思路：
 第一种：数据存到set中，最后创建一个链表；（空间成本有点高）
 第二种：直接在链表上进行遍历，跳过重复数据，向下继续走；
 时间空间复杂度分析：O（n）
 总结：
 */
public class Solution {

    /**
     * 官网答案
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //思维还是不够灵活，记住这个套路吧。选点很重要；
        //这类问题，直接定义一个变量指向原来的链，然后改变这个变量
        //实际考察：链表删除操作，记住first,跳过second，链接first.next =  second.next;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
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