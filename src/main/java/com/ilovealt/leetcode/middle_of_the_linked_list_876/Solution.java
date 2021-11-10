package com.ilovealt.leetcode.middle_of_the_linked_list_876;

/**
 数据范围、前提条件和边界条件： 节点数量在1-100之间；
 解题思路：
 第一种：定义一个数组集合，把节点存进去，然后集合长度/2，就能得到中间点；时间复杂度和空间复杂度 O(n)
 第二种：快慢指针方法，同时出发，慢指针走一步，快指针走两步；时间复杂度 O(n) 空间复杂度 O(1)
 第三种：遍历获取个数；第一遍获取长度，第二遍 到达中间位置停下；时间复杂度 O(n) 空间复杂度 O(1)
 时间空间复杂度分析：
 总结：
 */
public class Solution {

 public ListNode middleNode(ListNode head) {
  ListNode slow = head;
  ListNode fast = head;
  while (fast != null && fast.next != null) {
       slow = slow.next;
       fast = fast.next.next;
  }
  return slow;
 }

}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}