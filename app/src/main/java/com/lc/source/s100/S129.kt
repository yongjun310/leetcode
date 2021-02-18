package com.lc.source.s100

import java.util.*
import java.util.concurrent.LinkedBlockingQueue

/*
129. Sum Root to Leaf Numbers
Medium

2071

53

Add to List

Share
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
Accepted
316,316
Submissions
622,239
 */

class S129 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var retval = 0
        if (root.left == null && root.right == null) {
            return root.`val`
        }
        var tenroot = root.`val` * 10
        if (root.left != null) {
            root.left!!.`val` += tenroot
            retval += sumNumbers(root.left)
        }
        if (root.right != null) {
            root.right!!.`val` += tenroot
            retval += sumNumbers(root.right)
        }
        return retval
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}