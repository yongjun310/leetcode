package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
112. Path Sum
Easy

2128

515

Add to List

Share
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

class S112 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if(root == null) {
            return false
        }
        if(root.left == null && root.right == null && root.`val` == sum){
            return true
        }
        return hasPathSum(root.left, sum-root.`val`) || hasPathSum(root.right, sum-root.`val`)
    }

}