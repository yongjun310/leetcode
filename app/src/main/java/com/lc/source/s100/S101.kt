package com.lc.source.s100

/*
101. Symmetric Tree
Easy

4412

108

Add to List

Share
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3


But the following [1,2,2,null,2,null,2] is not:

    1
   / \
  2   2
   \   \
   2    2
n 2 2 1 n 2 2
Follow up: Solve it both recursively and iteratively.
 */

class S101 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isMirror(left: TreeNode?, right: TreeNode?) : Boolean {
        if(left == null && right == null) {
            return true
        } else if(!(left != null && right != null)) {
            return false
        } else if(left.left == null && left.right == null && right.left == null && right.right == null) {
            return left.`val` == right.`val`
        }
        return left.`val` == right.`val` && isMirror(left.right, right.left) && isMirror(left.left, right.right)
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return isMirror(root.left, root.right)
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var a = TreeNode(1)
            var b = TreeNode(2)
            var c = TreeNode(2)
            var d = TreeNode(2)
            var e = TreeNode(2)
            a.left = b
            a.right = c
            b.right = d
            c.right = e
            println(S101().isSymmetric(a))
        }
    }
}