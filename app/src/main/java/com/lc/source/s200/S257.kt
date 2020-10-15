package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.min

/*
257. Binary Tree Paths
Easy

2039

117

Add to List

Share
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
Accepted
344,019
Submissions
658,219
 */

class S257 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var list = ArrayList<String>()
    fun binaryTreePaths(root: TreeNode?): List<String> {
        var sb = StringBuilder()
        if(root != null) {
            findPath(root, sb)
        }
        return list
    }

    private fun findPath(root: TreeNode, sb: StringBuilder) {
        sb.append(root.`val`)
        if(root.left != null || root.right != null) {
            sb.append("->")
        } else if(root.left == null && root.right == null) {
            list.add(sb.toString())
        }
        if(root.left != null) {
            findPath(root.left!!, StringBuilder().append(sb.toString()))
        }
        if(root.right != null){
            findPath(root.right!!, StringBuilder().append(sb.toString()))
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var a1 = TreeNode(1)
            var a2 = TreeNode(2)
            var a3 = TreeNode(3)
            var a5 = TreeNode(5)
            a1.left = a2
            a1.right = a3
            a2.right = a5
            S257().binaryTreePaths(a1)
        }
    }
}