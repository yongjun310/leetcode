package com.lc.source.s600;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
653. Two Sum IV - Input is a BST
Easy

1533

141

Add to List

Share
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class S653 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(-1);
        TreeNode e = new TreeNode(0);
        a.left = b;
        b.left = c;
        c.right = d;
        d.right = e;
        boolean minDepth = new S653().findTarget(a, -3);
        System.out.print(" " + minDepth);

    }

    public boolean find(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (root.val < k) {
            return find(root.right, k);
        } else if (root.val > k) {
            return find(root.left, k);
        } else {
            return true;
        }
    }

    public boolean findBothSub(TreeNode root, int k) {
        if (root == null || root.left == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        boolean val = find(root.right, k - root.val) || find(root.left, k - root.val);
        if (val) {
            return true;
        }
        queue.add(root.left);
        int count = 1, nextCount = 0;
        while (count > 0) {
            while (count-- > 0) {
                TreeNode curNode = queue.poll();
                boolean res = find(root.right, k - curNode.val);
                if (res) {
                    return true;
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                    nextCount++;
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                    nextCount++;
                }
            }
            count = nextCount;
            nextCount = 0;
        }
        return false;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        boolean ret = find(root.left, k - root.val) || find(root.right, k - root.val);
        if (ret) {
            return ret;
        }
        if (k < root.val * 2) {
            ret = ret || findTarget(root.left, k);
            ret = ret || findBothSub(root, k);
        }
        if (k > root.val * 2) {
            ret = ret || findTarget(root.right, k);
            ret = ret || findBothSub(root, k);
        }
        ret = ret || findBothSub(root, k);
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
