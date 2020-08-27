package com.lc.source.s800

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

/*
872. Leaf-Similar Trees
Easy

827

42

Add to List

Share
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.



Constraints:

Both of the given trees will have between 1 and 200 nodes.
Both of the given trees will have values between 0 and 200
Accepted
95,692
Submissions
148,231
 */

class S872 {
    class TreeNode(var `val`: Int) {
       var left: TreeNode? = null
       var right: TreeNode? = null
    }

    fun leafEnqueue(root1: TreeNode?, queue: Queue<Int>) {
        if(root1 == null) {
            return
        }
        if(root1.left != null) {
            leafEnqueue(root1.left, queue)
        }
        if(root1.right != null) {
            leafEnqueue(root1.right, queue)
        }
        if(root1.left == null && root1.right == null) {
            queue.add(root1.`val`)
        }
    }

    var ret = true
    fun leafDequeue(root1: TreeNode?, queue: Queue<Int>) {
        if(!ret) {
            return
        }
        if(root1 == null) {
            ret = queue.isEmpty()
            return
        }
        if(root1.left != null) {
            leafDequeue(root1.left, queue)
        }
        if(root1.right != null) {
            leafDequeue(root1.right, queue)
        }
        if(root1.left == null && root1.right == null) {
            ret = queue.poll() == root1.`val`
        }
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        var queue = LinkedBlockingQueue<Int>()
        leafEnqueue(root1, queue)
        leafDequeue(root2, queue)
        return ret
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}