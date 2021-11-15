package com.ilovealt.leetcode.happy_number_202;

import java.util.HashSet;
import java.util.Set;

/**
 数据范围、前提条件和边界条件： n为正整数
 解题思路：
 第一种：哈希表：单独写一个方法计算每一个层级的求和操作；然后使用Set判断每一个和是不是已经存在，如果存在表示有循环，否则等于1；
 第二种：快慢指针：把求解过程中得到的求和数据链接成一个链表，1.快指针先到1；2.快慢指针在同一个数字相遇；
 时间空间复杂度分析：
 总结：
 */
public class Solution {

    /**
     * 每个数据拆分求和
     */
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n /10;
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * Set 判重
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = this.getNext(n);
        }
        return n == 1;
    }

    /**
     * 快慢指针
     */
    public boolean isHappy1(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }


}
