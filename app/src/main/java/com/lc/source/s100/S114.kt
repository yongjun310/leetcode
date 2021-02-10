package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
114. Flatten Binary Tree to Linked List
Medium

3841

391

Add to List

Share
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.


Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100


Follow up: Can you flatten the tree in-place (with O(1) extra space)?
Accepted
413,196
Submissions
798,664
 */

class S114 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        root.left?.let { flatten(it) }
        var r = root.right
        if (root.left != null) {
            root.right = root.left
            var cur = root.left
            while (cur!!.right != null) {
                cur = cur.right
            }
            cur.right = r
            root.left = null
        }
        flatten(r)
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
            var s = S114().flatten(l0)
            print(s)
        }
    }
}