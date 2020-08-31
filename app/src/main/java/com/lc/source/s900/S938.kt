package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
938. Range Sum of BST
Easy

1390

236

Add to List

Share
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.



Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23


Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.
Accepted
240,941
Submissions
295,627
 */

class S938 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        if(root == null) {
            return 0
        }
        var left = 0
        var right = 0
        if(root.left != null) {
            left =  rangeSumBST(root.left, L, R)
        }
        if(root.right != null) {
            right =  rangeSumBST(root.right, L, R)
        }
        if(root.`val`<L) {
            return right
        }else if(root.`val`>R) {
            return left
        } else {
            return root.`val` + left + right
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}