package com.lc.source.s100

import kotlin.collections.HashMap


/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

2418

44

Add to List

Share
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
Accepted
279,385
Submissions
565,050
 */

class S106{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        var map = HashMap<Int, Int>()
        for (i in inorder.indices) {
            map[inorder[i]] = i
        }
        var t = helper(postorder, inorder,0, postorder.size-1, 0, inorder.size-1, map)
        return t
    }

    fun helper(postorder: IntArray, inorder: IntArray, ps: Int, pe: Int, ins: Int, ine: Int, map: HashMap<Int, Int>): TreeNode? {
        if (ps>pe || ins>ine) {
            return null
        }
        var index = map[postorder[pe]]
        var retNode = TreeNode(postorder[pe])
        if (index != null) {
            retNode.left = helper(postorder, inorder, ps, ps+index-ins-1, ins, index-1, map)
            retNode.right = helper(postorder, inorder, ps+index -ins, pe-1, index+1, ine, map)
        }
        return retNode
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S106().buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3)))
        }
    }
}