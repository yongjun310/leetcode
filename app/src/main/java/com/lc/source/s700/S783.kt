package com.lc.source.s700

/*
783. Minimum Distance Between BST Nodes
Easy

731

209

Add to List

Share
Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
Note:

The size of the BST will be between 2 and 100.
The BST is always valid, each node's value is an integer, and each node's value is different.
This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */

class S783 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    var a = ArrayList<Int>()
    fun minDiffInBST(root: TreeNode?): Int {
        tranvTree(root)
        var m = Integer.MAX_VALUE
        for(i in 1..a.size-1) {
            var d = Math.abs(a[i] - a[i-1])
            if(d<m) {
                m = d
            }
        }
        return m
    }

    private fun tranvTree(root: TreeNode?) {
        if (root == null) {
            return
        }
        if (root.left != null) {
            minDiffInBST(root.left)
        }
        a.add(root.`val`)

        if (root.right != null) {
            minDiffInBST(root.right)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}