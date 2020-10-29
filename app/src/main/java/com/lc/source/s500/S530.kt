package com.lc.source.s500

import kotlin.collections.ArrayList

/*
530. Minimum Absolute Difference in BST
Easy

1007

77

Add to List

Share
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).


Note:

There are at least two nodes in this BST.
This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
Accepted
98,420
Submissions
181,487
 */

class S530{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inSearchTree(root: TreeNode, list: ArrayList<Int>) {
        if(root.left != null) {
            inSearchTree(root.left!!, list)
        }
        list.add(root.`val`)
        if(root.right != null) {
            inSearchTree(root.right!!, list)
        }
    }

    fun getMinimumDifference(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        var list = ArrayList<Int>()
        inSearchTree(root, list)
        var ret = Int.MAX_VALUE
        for(i in 1 until list.size) {
            if(list[i]-list[i-1]<ret) {
                ret = list[i]-list[i-1]
            }
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}