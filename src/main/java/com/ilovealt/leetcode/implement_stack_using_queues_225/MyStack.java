package com.ilovealt.leetcode.implement_stack_using_queues_225;

import java.util.LinkedList;
import java.util.Queue;

/**
 数据范围、前提条件和边界条件：
 解题思路：
 第一种：
 第二种：
 时间空间复杂度分析：
 总结：
 */
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * 在push代码中 实现两个队列的切换
     * queue2保存反转后的结果，然后修改变量名为queue1，使主操作都在queue1上；
     * @param x 数据
     */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
       return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
