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
103. Binary Tree Zigzag Level Order Traversal
Medium

3048

122

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
Accepted
470,858
Submissions
942,341
 */

class S103{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        var queue = Stack<TreeNode>()
        var lqueue = Stack<TreeNode>()
        var list = ArrayList<ArrayList<Int>>()
        if (root == null) {
            return list
        }
        queue.push(root)
        while (true) {
            var cl = ArrayList<Int>()
            var curNode : TreeNode?
            var q = if (queue.isEmpty()) lqueue else queue
            if (q.isEmpty()) {
                break
            }
            var nq = if (q == queue) lqueue else queue
            while (q.isNotEmpty()) {
                curNode = q.pop()
                curNode?.`val`?.let { cl.add(it) }
                if (nq != lqueue) {
                    if (curNode.left != null) {
                        nq.push(curNode.left)
                    }
                    if (curNode.right != null) {
                        nq.push(curNode.right)
                    }
                } else {
                    if (curNode.right != null) {
                        nq.push(curNode.right)
                    }
                    if (curNode.left != null) {
                        nq.push(curNode.left)
                    }
                }
                var q = if (queue.isEmpty()) lqueue else queue
                if (q.isEmpty()) {
                    break
                }
            }
            if (cl.isEmpty()) {
                break
            } else {
                list.add(cl)
            }
        }
        return list
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = TreeNode(1)
            var n2 = TreeNode(2)
            var n3 = TreeNode(3)
            var n4 = TreeNode(4)
            var n5 = TreeNode(5)
            n1.left = n2
            n1.right = n3
            n2.left = n4
            n2.right = n5
            print(S103().zigzagLevelOrder(n1))
        }
    }
}