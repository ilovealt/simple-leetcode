package com.ilovealt.leetcode.implement_queue_using_stacks_232;

import java.util.Stack;

/**
 数据范围、前提条件和边界条件：
 解题思路：
 第一种：
 第二种：
 时间空间复杂度分析：
 总结：
 */
public class MyQueue {

    Stack<Integer> master;
    Stack<Integer> minor;

    public MyQueue() {
        master = new Stack<>();
        minor = new Stack<>();
    }

    /**
     * 倒腾数据呗
     * @param x 数据
     */
    public void push(int x) {
        //主栈 反转到 次栈
        while (!master.isEmpty()) {
            minor.push(master.pop());
        }
        //把数据放到主栈
        master.push(x);
        //次栈 反转到 主栈
        while (!minor.isEmpty()) {
            master.push(minor.pop());
        }
    }

    public int pop() {
        return master.pop();
    }

    public int peek() {
        return master.peek();
    }

    public boolean empty() {
        return master.empty();
    }

}
