package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
965. Univalued Binary Tree
Easy

591

42

Add to List

Share
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.



Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false


Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].
Accepted
95,050
Submissions
140,555
 */

class S965 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isUnival(root: TreeNode?, v:Int):Boolean {
        if(root == null) {
            return true
        } else if(root.`val` != v) {
            return false
        } else {
            return isUnival(root.left, v) && isUnival(root.right, v)
        }
    }

    fun isUnivalTree(root: TreeNode?): Boolean {
        if (root != null) {
            return isUnival(root.left, root.`val`) && isUnival(root.right, root.`val`)
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var a = TreeNode(1)
            var b = TreeNode(1)
            var c = TreeNode(5)
            a.left = b
            a.right = c
            println(S965().isUnivalTree(a))
        }
    }

}