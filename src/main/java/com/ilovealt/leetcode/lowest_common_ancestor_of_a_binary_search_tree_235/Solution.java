package com.ilovealt.leetcode.lowest_common_ancestor_of_a_binary_search_tree_235;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright: Copyright (c) 2021 HighGoal.
 * <p> </p>
 *
 * @author wangs
 * @since 2021/11/18 8:43
 */
public class Solution {

    /**
     * 原始方法，常规思路
     */
   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       List<TreeNode> pp = getPath(root, p);
       List<TreeNode> pq = getPath(root, q);
       //break 困惑
       TreeNode ancestor = null;
       for (int i = 0; i < pp.size() && i < pq.size(); ++i) {
           if (pp.get(i) == pq.get(i)) {
               ancestor = pp.get(i);
           } else {
               break;
           }
       }
       return ancestor;
   }

    /**
     * 记录查找目标节点经过的路径
     */
   private List<TreeNode> getPath(TreeNode root, TreeNode target) {
       List<TreeNode> path = new ArrayList<>();
       TreeNode node = root;
       while (node != target) {
           path.add(node);
           if (target.val < node.val) {
               node = node.left;
           } else {
               node = node.right;
           }
       }
       //把自己添加进路径
       path.add(node);
       return path;
   }


    /**
     * 官网
     * 如果当前节点的值大于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
     * 如果当前节点的值小于 pp 和 qq 的值，说明 pp 和 qq 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
     * 如果当前节点的值不满足上述两条要求，那么说明当前节点就是「分岔点」。此时，pp 和 qq 要么在当前节点的不同的子树中，要么其中一个就是当前节点。
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

}


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}