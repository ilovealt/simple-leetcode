package com.ilovealt.leetcode.convert_sorted_array_to_binary_search_tree_108;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p>
 *
 * </p>
 *
 * @author wangs
 * @since 2021/11/18 8:21
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    /**
     * 优先选 左边 的数字作为根节点
     */
    public TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //总是选择中间位置 左边 的数字作为根节点
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid, right-1);
        return root;
    }

    /**
     * 优先选 右边 的数字作为根节点
     */
    public TreeNode helper1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        //总是选择中间位置 右边 的数字作为根节点
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid-1);
        root.right = helper(nums, mid, right-1);
        return root;
    }

}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}