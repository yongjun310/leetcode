package com.lc.source.s600;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
637. Average of Levels in Binary Tree
Easy

1331

167

Add to List

Share
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
 */
public class S637 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        List minDepth = new S637().averageOfLevels(a);
        for (Object ds : minDepth) {
            System.out.print(" " + ds);
        }

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List ret = new LinkedList();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int curSize = 1, nextSize = 0, count;
        Double ave, total = 0d;
        while (curSize > 0) {
            count = curSize;
            while (curSize-- > 0) {
                TreeNode treeNode = queue.poll();
                total = total + treeNode.val;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    nextSize++;
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    nextSize++;
                }
            }
            ret.add(total / count);
            curSize = nextSize;
            nextSize = 0;
            total = 0d;
        }
        return ret;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
