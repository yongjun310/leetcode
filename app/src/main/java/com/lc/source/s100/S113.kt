package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
113. Path Sum II
Medium

2505

86

Add to List

Share
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
Accepted
391,280
Submissions
799,612
 */

class S113 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        var retList = ArrayList<List<Int>>()
        var list = ArrayList<Int>()
        if (root == null) {
            return retList
        }
        helper(root, targetSum, retList, list)
        return retList
    }

    fun helper(root: TreeNode, targetSum: Int, retList:ArrayList<List<Int>>, curList:ArrayList<Int>) {
        if (root.left == null && root.right == null && targetSum == 0) {
            if (curList.size>0 && root.`val` == 0) {
                curList.add(root.`val`)
                retList.add(curList)
            }
            return
        }
        if (root?.`val` == targetSum && root.left == null && root.right == null) {
            curList.add(root.`val`)
            retList.add(curList)
            return
        } else {
            curList.add(root.`val`)
            var cl = curList.clone() as ArrayList<Int>
            root.left?.let { helper(it, targetSum-root.`val`, retList, curList) }
            root.right?.let { helper(it, targetSum-root.`val`, retList, cl) }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var l0 = TreeNode(1)
            var l1 = TreeNode(-2)
            var l2 = TreeNode(-3)
            var l3 = TreeNode(1)
            var l4 = TreeNode(3)
            var l5 = TreeNode(-2)
            var l6 = TreeNode(-1)
            l0.left = l1
            l0.right = l2
            l1.left = l3
            l1.right = l4
            l2.left = l5
            l3.left = l6
            var s = S113().pathSum(l0,-1)
            print(s)
        }
    }
}