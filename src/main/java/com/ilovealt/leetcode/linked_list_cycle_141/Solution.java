package com.ilovealt.leetcode.linked_list_cycle_141;

import java.util.HashSet;
import java.util.Set;

/**
 数据范围、前提条件和边界条件： 节点数目；值整数；pos为-1或者链表中的有效索引；
 解题思路：
 第一种：哈希表；存储已经访问过的节点，存在则有环，否则无；
 第二种：快慢指针；一快一慢，如果移动过程中有重合说明存在环；基于第一点两个指针开始节点不能都为head；可以慢为head快为head.next；
 时间空间复杂度分析：O(n)
 总结：快慢指针：1.开始节点不同；2.循环中添加快指针判断结束条件；3.慢指针走一步，快指针走两步；
 */
public class Solution {

    /**
     * 哈希表
     * @param head 头节点
     * @return 结果
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head 头节点
     * @return 结果
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            //如果fast已经到头了，就说明没有环
            if (fast == null || fast.next == null) {
                return false;
            }
            //走一步
            slow = slow.next;
            //走两步
            fast = fast.next.next;
        }
        return true;
    }

}

/**
 * 节点
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}