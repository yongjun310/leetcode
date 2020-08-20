package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
107. Binary Tree Level Order Traversal II
Easy

1576

216

Add to List

Share
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
 */

class S107 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        var ret = mutableListOf<List<Int>>()
        var queue = ConcurrentLinkedQueue<TreeNode>()
        if(root == null) {
            return ret
        }
        queue.add(root)
        while(queue.isNotEmpty()) {
            var list = mutableListOf<Int>()
            var size = queue.size
            while(size > 0) {
                var node = queue.poll()
                list.add(node.`val`)
                size--
                if(node.left != null) {
                    queue.add(node.left)
                }
                if(node.right != null) {
                    queue.add(node.right)
                }
            }
            ret.add(0, list)
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var a = TreeNode(1)
            var b = TreeNode(2)
            var c = TreeNode(3)
            var d = TreeNode(3)
            var e = TreeNode(2)
            a.left = b
            a.right = c
            b.right = d
            c.right = e
            println(S107().levelOrderBottom(a))
        }
    }
}