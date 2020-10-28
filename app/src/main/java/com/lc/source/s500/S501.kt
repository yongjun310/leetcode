package com.lc.source.s500

import kotlin.collections.ArrayList

/*
501. Find Mode in Binary Search Tree
Easy

1050

376

Add to List

Share
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

Accepted
94,576
Submissions
220,808
 */

class S501{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun inSearchTree(root: TreeNode, list: ArrayList<Int>) {
        if(root.left != null) {
            inSearchTree(root.left!!, list)
        }
        list.add(root.`val`)
        if(root.right != null) {
            inSearchTree(root.right!!, list)
        }
    }

    fun findMode(root: TreeNode?): IntArray {
        var rl = ArrayList<Int>()
        if(root == null) {
            return rl.toIntArray()
        }
        var list = ArrayList<Int>()
        inSearchTree(root, list)
        if(list.size == 1) {
            rl.add(list[0])
        } else {
            var lastmax = -1
            var cur = 1
            for (i in 1..list.size - 1) {
                if (list[i] == list[i - 1]) {
                    cur++
                    if (i == list.size - 1) {
                        if (cur > lastmax) {
                            rl.clear()
                            rl.add(list[i - 1])
                            lastmax = cur
                        } else if (cur == lastmax) {
                            rl.add(list[i - 1])
                        }
                    }
                } else {
                    if (cur > lastmax) {
                        rl.clear()
                        rl.add(list[i - 1])
                        lastmax = cur
                    } else if (cur == lastmax) {
                        rl.add(list[i - 1])
                    }
                    cur = 1
                    if(i==list.size-1 && lastmax == 1) {
                        rl.add(list[list.size-1])
                    }
                }
            }
        }
        return rl.toIntArray()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var n1 = TreeNode(1)
            var n2 = TreeNode(2)
            n1.right = n2
            S501().findMode(n1)

        }
    }
}