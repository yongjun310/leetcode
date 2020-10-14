package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
226. Invert Binary Tree
Easy

4013

66

Add to List

Share
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
Accepted
588,609
Submissions
894,985
 */

class S226 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invert(node: TreeNode?) {
        if(node == null) {
            return
        }
        var left = node.left
        var right = node.right
        var temp = left
        node.left = right
        node.right = temp
        invert(left)
        invert(right)
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        invert(root)
        return root
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}