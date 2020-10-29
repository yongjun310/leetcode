package com.lc.source.s500

import kotlin.collections.ArrayList

/*
543. Diameter of Binary Tree
Easy

3702

221

Add to List

Share
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

Accepted
389,952
Submissions
799,641
 */

class S543{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun deep(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        return Math.max(deep(root.left), deep(root.right)) + 1
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        return Math.max(deep(root.left)+deep(root.right), Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)))
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}