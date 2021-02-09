package com.lc.source.s100

import org.w3c.dom.Node
import java.util.*
import java.util.concurrent.BlockingDeque
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max
import java.util.Queue as Queue1


/*
105. Construct Binary Tree from Preorder and Inorder Traversal
Medium

4674

120

Add to List

Share
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
Accepted
454,366
Submissions
881,114
 */

class S105{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var map = HashMap<Int, Int>()
        for (i in inorder.indices) {
            map[inorder[i]] = i
        }
        var t = helper(preorder, inorder, 0, preorder.size, 0, inorder.size, map)
        return t
    }

    fun helper(preorder: IntArray, inorder: IntArray, ps: Int, pe: Int, ins: Int, ine: Int, map: HashMap<Int, Int>): TreeNode? {
        if (ps>=pe || ins>=ine) {
            return null
        }
        var index = map[preorder[ps]]
        var retNode = TreeNode(preorder[ps])
        if (index != null) {
            retNode.left = helper(preorder, inorder, ps+1, ps + index+1-ins, ins, index, map)
            retNode.right = helper(preorder, inorder, ps + index+1-ins, pe, index+1, ine, map)
        }
        return retNode
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S105().buildTree(intArrayOf(1,2,3), intArrayOf(3,2,1)))
        }
    }
}