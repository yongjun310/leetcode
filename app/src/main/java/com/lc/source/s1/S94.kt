package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/*
94. Binary Tree Inorder Traversal
Medium

4217

187

Add to List

Share
Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,3,2]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [2,1]
Example 5:


Input: root = [1,null,2]
Output: [1,2]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up:

Recursive solution is trivial, could you do it iteratively?



Accepted
905,225
Submissions
1,378,802
 */

class S94{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }
    fun inorderTraversal(root: TreeNode?): List<Int> {
        var retList = ArrayList<Int>()
        if (root == null) {
            return retList
        }
        helper(root, retList)
        return retList
    }

    fun helper(root: TreeNode, list: ArrayList<Int>) {
        if (root.left != null) {
            helper(root.left!!, list)
        }
        list.add(root.`val`)
        if (root.right != null) {
            helper(root.right!!, list)
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S94().restoreIpAddresses("010010"))
        }
    }
}