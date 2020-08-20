package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
108. Convert Sorted Array to Binary Search Tree
Easy

Add to List

Share
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */

class S108 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if(nums.isEmpty()) {
            return null
        }
        var root = TreeNode()
        root.`val` = nums[nums.size/2]
        root.left = sortedArrayToBST(nums.copyOfRange(0, nums.size/2))
        root.right = sortedArrayToBST(nums.copyOfRange(nums.size/2+1, nums.size))
        return root
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var a = listOf(-10,-3,0,5,9)
            var s = S108().sortedArrayToBST(a.toIntArray())
            print(s)
        }
    }
}