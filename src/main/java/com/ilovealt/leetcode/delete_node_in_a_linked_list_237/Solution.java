package com.ilovealt.leetcode.delete_node_in_a_linked_list_237;

/**
 数据范围、前提条件和边界条件：节点数量 2-1000之间；链表中每个节点数值唯一；
 解题思路：
 第一种：没法直接使用next操作，需要把当前节点的值替换为下一个节点；
 第二种：
 时间空间复杂度分析：
 总结：
 */
public class Solution {

  public void deleteNode(ListNode node) {
   node.val = node.next.val;
   node.next = node.next.next;
  }
}


class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}