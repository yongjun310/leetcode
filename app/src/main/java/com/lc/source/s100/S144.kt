package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/*
144. Binary Tree Preorder Traversal
Medium

2152

87

Add to List

Share
Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:


Input: root = [1,2]
Output: [1,2]
Example 5:


Input: root = [1,null,2]
Output: [1,2]


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?

Accepted
613,871
Submissions
1,063,549
 */

class S144 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var list = ArrayList<Int>()
    fun preorderTraversal(root: TreeNode?): List<Int> {
        helper(root)
        return list
    }

    fun helper(root: TreeNode?) {
        if (root == null) {
            return
        }
        list.add(root.`val`)
        helper(root.left)
        helper(root.right)
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}