package com.ilovealt.leetcode.merge_sorted_array_88;

/**
 数据范围、前提条件和边界条件：
    非递减顺序；合并数据放到nums1中，数组容量够；
    合并后还是 非递减顺序；
 解题思路：
    第一种：两个数据都是从后往前遍历取值；分别一步一步往前走，每次都做对比；开始分别是m和n，存放对比结果是从m+n处开始；
            有哪个没走完，全部迁移；结束；
    第二种：两个正常从头开始遍历，类似第一种
 总结：
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        int mi = m-1;
        int ni = n-1;
        for (;i>=0 && mi>=0 && ni >=0; i--) {
            if (nums1[mi] > nums2[ni]) {
                nums1[i] = nums1[mi--];
            } else {
                nums1[i] = nums2[ni--];
            }
        }

        if (ni>=0) {
            for (int j = ni; j >= 0 ; j--) {
                nums1[i--] = nums2[j];
            }
        }

    }

}
