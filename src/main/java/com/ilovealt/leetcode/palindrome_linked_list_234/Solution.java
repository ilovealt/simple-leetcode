package com.ilovealt.leetcode.palindrome_linked_list_234;

import java.util.ArrayList;
import java.util.List;

/**
 数据范围、前提条件和边界条件： 链表长度可控；值为非负数；
 解题思路：
 第一种： 迭代：使用数组保存链表数据，然后使用头尾便利的方式，对比值； 时间复杂度和空间复杂度O(n)
 第二种：递归 也是使用首位对比的方式；时间复杂度和空间复杂度O(n)
 第三种：快慢指针，这个目前并不懂
 总结：
 */
public class Solution {

    /**
     * 迭代 使用数组列表
     */
    public boolean isPalindrome(ListNode head) {
        //填充列表
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        //遍历列表
        int front = 0;
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            //移动
            front++;
            back--;
        }
        return true;
    }

    private ListNode frontNode;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (frontNode.val != currentNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
    }

    /**
     * 递归  使用
     */
    public boolean isPalindrome1(ListNode head) {
        frontNode = head;
        return recursivelyCheck(head);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}