package com.lc.source.s800

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

/*
897. Increasing Order Search Tree
Easy

738

471

Add to List

Share
Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9


Constraints:

The number of nodes in the given tree will be between 1 and 100.
Each node will have a unique integer value from 0 to 1000.
Accepted
71,958
Submissions
101,118
 */

class S897 {
    class TreeNode(var `val`: Int) {
       var left: TreeNode? = null
       var right: TreeNode? = null
    }

    var node = TreeNode(0)
    fun transTree(root: TreeNode?) {
        if(root == null) {
            return
        }
        transTree(root.left)
        node.right = root
        node = root
        node.left = null
        transTree(root.right)
    }

    fun increasingBST(root: TreeNode?): TreeNode? {
        var head = node
        transTree(root)
        return head.right
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}