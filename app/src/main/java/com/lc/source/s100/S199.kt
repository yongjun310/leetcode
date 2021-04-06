package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.math.min

/*
199. Binary Tree Right Side View
Medium

3711

200

Add to List

Share
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:


Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
Example 2:

Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
Accepted
430,528
Submissions
761,450
 */

class S199 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        var list = helper(root)
        var retlist = ArrayList<Int>()
        for (e in list) {
            retlist.add(e.`val`)
        }
        return retlist
    }

    fun helper(root: TreeNode?): ArrayList<TreeNode> {
        var list = ArrayList<TreeNode>()
        if (root != null) {
            var ll = helper(root.left)
            var rl = helper(root.right)
            if (ll.size > rl.size) {
                for (i in rl.size until ll.size) {
                    rl.add(ll[i])
                }
            }
            list.addAll(rl)
            list.add(0, root)
        }
        return list
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}