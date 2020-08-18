package com.lc.source.s600;

/*
671. Second Minimum Node In a Binary Tree
Easy

626

866

Add to List

Share
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
 then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.


Example 2:

Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 */
public class S671 {
    public static void main(String[] args) {  //[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(8);
        TreeNode c = new TreeNode(5);
        a.left = b;
        a.right = c;
        System.out.println(new S671().findSecondMinimumValue(a));
    }

    public int visit(TreeNode root, int mini) {
        if(root == null) {
            return -1;
        }
        if(root.val != mini) {
            return root.val;
        }
        int sm = -1;
        int lm = visit(root.left, mini);
        int rm = visit(root.right, mini);
        if(lm != -1) {
            sm = lm;
        }
        if(rm != -1 && sm > rm) {
            sm = rm;
        }
        return sm;
    }

    public int findSecondMinimumValue(TreeNode root) {
        int sm = -1, m;
        if(root == null) {
            return sm;
        } else {
            m = root.val;
        }
        int lf = visit(root.left, m);
        int rf = visit(root.right, m);
        if(lf != -1) {
            sm = lf;
        }
        if(sm == -1) {
            sm = rf;
        } else if(sm > rf && rf != -1) {
            sm = rf;
        }
        return sm;
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
