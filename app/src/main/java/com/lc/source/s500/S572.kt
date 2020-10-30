package com.lc.source.s500

import kotlin.collections.ArrayList

/*
572. Subtree of Another Tree
Easy

2745

129

Add to List

Share
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.


Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.


Accepted
249,542
Submissions
563,686
 */

class S572{
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isSame(l: TreeNode?, r:TreeNode?): Boolean {
        if(l == null && r == null) {
            return true
        } else {
            if(l == null || r == null) {
                return false
            }
            if(l.`val` != r.`val`) {
                return false
            }
            return isSame(l.left, r.left) && isSame(l.right, r.right)
        }
    }

    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        if(s== null || t == null) {
            return false
        }
        if(s.`val` == t.`val` && isSame(s.left, t.left) && isSame(s.right, t.right)) {
            return true
        } else
            return isSubtree(s.left, t) || isSubtree(s.right, t)
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}