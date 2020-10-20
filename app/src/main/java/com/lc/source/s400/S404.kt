package com.lc.source.s400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
404. Sum of Left Leaves
Easy

1483

146

Add to List

Share
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
Accepted
217,936
Submissions
418,707
 */

class S404{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sumOfLeftLeaves(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right) + if(root.left != null && root.left!!.left == null && root.left!!.right == null) root.left!!.`val` else 0
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}