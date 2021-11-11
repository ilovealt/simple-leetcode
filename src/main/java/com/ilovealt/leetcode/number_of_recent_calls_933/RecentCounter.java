package com.ilovealt.leetcode.number_of_recent_calls_933;

import java.util.LinkedList;
import java.util.Queue;

/**
 数据范围、前提条件和边界条件：不用存历史，只需要存3000毫秒内的次数就可以；
 解题思路：
 第一种：使用队列
 第二种：
 时间空间复杂度分析：
 总结：
 */
public class RecentCounter {

    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t-3000) {
            queue.poll();
        }
        return queue.size();
    }

}
