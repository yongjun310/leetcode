package com.lc.source.s500

import kotlin.collections.ArrayList

/*
508. Most Frequent Subtree Sum
Medium

846

143

Add to List

Share
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

Accepted
82,643
Submissions
139,704
 */

class S508{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        var retList = ArrayList<Int>()
        if (root == null) {
            return retList.toIntArray()
        }
        sumTree(root)
        var map = HashMap<Int, Int>()
        insertMap(root, map)
        var iterator = map.iterator()
        var cur = Int.MIN_VALUE
        while (iterator.hasNext()) {
            var n = iterator.next()
            if (n.value>cur) {
                cur = n.value
            }
        }
        iterator = map.iterator()
        if (iterator.hasNext()) {
            var tn = iterator.next()
            if (cur == tn.value) {
                retList.add(tn.key)
            }
        }
        while (iterator.hasNext()) {
            var n = iterator.next()
            if (cur == n.value) {
                retList.add(n.key)
            }
        }
        return retList.toIntArray()
    }

    fun insertMap(root: TreeNode, map: HashMap<Int, Int>) {
        var v = map.get(root.`val`)
        if (v != null) {
            map.put(root.`val`, v+1)
        } else {
            map.put(root.`val`, 1)
        }
        if (root.left != null) {
            insertMap(root.left!!, map)
        }
        if (root.right != null) {
            insertMap(root.right!!, map)
        }
    }

    fun sumTree(root: TreeNode) {
        if (root.left != null) {
            sumTree(root.left!!)
            root.`val` += root.left!!.`val`
        }
        if (root.right != null) {
            sumTree(root.right!!)
            root.`val` += root.right!!.`val`
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = TreeNode(3)
            var n2 = TreeNode(1)
            var n3 = TreeNode(5)
            var n4 = TreeNode(0)
            var n5 = TreeNode(2)
            var n6 = TreeNode(4)
            var n7 = TreeNode(6)
            var n8 = TreeNode(3)
            n1.left = n2
            n1.right = n3
            n2.left = n4
            n2.right = n5
            n3.left = n6
            n3.right = n7
            n5.right = n8
            print(S508().findFrequentTreeSum(n1))
        }
    }
}