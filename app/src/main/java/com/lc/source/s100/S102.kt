package com.lc.source.s100

import org.w3c.dom.Node
import java.util.*
import java.util.concurrent.BlockingDeque
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.math.max
import java.util.Queue as Queue1


/*
102. Binary Tree Level Order Traversal
Medium

4158

101

Add to List

Share
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
Accepted
767,298
Submissions
1,359,003
 */

class S102{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var queue = LinkedBlockingQueue<TreeNode>()
        var list = ArrayList<ArrayList<Int>>()
        if (root == null) {
            return list
        }
        queue.put(root)
        var count = 1
        while (true) {
            var cl = ArrayList<Int>()
            var curNode : TreeNode?
            var nc = 0
            while (count-->0) {
                curNode = queue.poll()
                curNode?.`val`?.let { cl.add(it) }
                if (curNode.left != null) {
                    queue.put(curNode.left)
                    nc++
                }
                if (curNode.right != null) {
                    queue.put(curNode.right)
                    nc++
                }
            }
            if (cl.isEmpty()) {
                break
            } else {
                list.add(cl)
            }
            count = nc
        }
        return list
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = TreeNode(3)
            var n2 = TreeNode(9)
            var n3 = TreeNode(20)
            var n4 = TreeNode(15)
            var n5 = TreeNode(7)
            n1.left = n2
            n1.right = n3
            n3.left = n4
            n3.right = n5
            print(S102().levelOrder(n1))
        }
    }
}