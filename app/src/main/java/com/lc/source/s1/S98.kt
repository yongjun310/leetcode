package com.lc.source.s1

import org.w3c.dom.Node
import kotlin.collections.ArrayList
import kotlin.math.max


/*
98. Validate Binary Search Tree
Medium

5427

646

Add to List

Share
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
Accepted
898,959
Submissions
3,133,641
 */

class S98{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return helper(root, Int.MIN_VALUE.toLong()-1, Int.MAX_VALUE.toLong()+1)
    }

    fun helper(node: TreeNode?, minv: Long, maxv: Long): Boolean {
        var ret = true
        if (node != null) {
            if (node.`val` <= minv || node.`val` >= maxv) {
                return false
            }
            ret = ret && helper(node.left, minv, node.`val`.toLong()) && helper(node.right, node.`val`.toLong(), maxv)
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}