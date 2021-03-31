package com.lc.sword.offer

import kotlin.collections.ArrayList
import kotlin.collections.HashSet

// 1 2->3->4 ->2
class Microsoft_loop_2 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    var nodeSet = HashSet<TreeNode>()
    var doublePointNode : TreeNode? = null
    var doublePointParentList : ArrayList<TreeNode> = ArrayList()
    fun findErrNode(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        travalTree(root)
        if (doublePointNode != null) {
            findParentNode(root)
        }
        for (e in doublePointParentList) {
            var isLeft = e.left != null
            if (e.left != null) {
                e.left = null
            } else {
                e.right = null
            }
            var reachable = canReachDoublePointNode(root)
            if (reachable) {
                if (isLeft) {
                    e.left = doublePointNode
                } else {
                    e.right = doublePointNode
                }
                return e
            }
        }
        return null
    }

    private fun canReachDoublePointNode(root: TreeNode?) : Boolean {
        if (root == null) {
            return false
        }
        if (root == doublePointNode) {
            return true
        } else {
            return canReachDoublePointNode(root?.left) || canReachDoublePointNode(root?.right)
        }
    }

    private fun findParentNode(root: TreeNode) {
        if (root.left == doublePointNode && root.right == null
                || root.right == doublePointNode && root.left == null) {
            doublePointParentList.add(root)
        }
        if (root.left != null) {
            findParentNode(root.left!!)
        }
        if (root.right != null) {
            findParentNode(root.right!!)
        }
    }

    private fun travalTree(root: TreeNode) {
        if (!nodeSet.contains(root)) {
            nodeSet.add(root)
        } else {
            doublePointNode = root
        }
        if (root.left != null && !nodeSet.contains(root.left)) {
            travalTree(root.left!!)
        }
        if (root.right != null && !nodeSet.contains(root.right)) {
            travalTree(root.right!!)
        }
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}