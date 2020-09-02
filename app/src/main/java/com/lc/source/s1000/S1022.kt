package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1022. Sum of Root To Leaf Binary Numbers
Easy

589

74

Add to List

Share
Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.



Example 1:



Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


Note:

The number of nodes in the tree is between 1 and 1000.
node.val is 0 or 1.
The answer will not exceed 2^31 - 1.
Accepted
46,035
Submissions
68,271
 */

class S1022 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    var sum = 0
    fun sumRoot(root: TreeNode?, cur: Int) {
        if(root?.left == null && root?.right == null) {
            sum += cur
            return
        }
        if(root?.left != null) {
            sumRoot(root.left, (cur shl 1) + root.left!!.`val`)
        }
        if(root?.right != null) {
            sumRoot(root.right, (cur shl 1) + root.right!!.`val`)
        }
    }

    fun sumRootToLeaf(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }
        sumRoot(root, root.`val`)
        return sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var a = TreeNode(1)
            var b = TreeNode(0)
            var c = TreeNode(1)
            var bl = TreeNode(0)
            var br = TreeNode(1)
            var cl = TreeNode(0)
            var cr = TreeNode(1)
            a.left = b
            a.right = c
            b.left = bl
            b.right = br
            c.left = cl
            c.right = cr
            print(S1022().sumRootToLeaf(a))
        }
    }

}