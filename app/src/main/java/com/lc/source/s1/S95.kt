package com.lc.source.s1

import kotlin.collections.ArrayList


/*
95. Unique Binary Search Trees II
Medium

2809

197

Add to List

Share
Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.



Example 1:


Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 8
Accepted
219,189
Submissions
517,744
 */

class S95{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun generateTrees(n: Int): List<TreeNode?> {
        var retl = findTree(1, n)
        return retl
    }

    fun findTree(s:Int, e:Int):List<TreeNode?> {
        var list = ArrayList<TreeNode?>()
        if (s>e) list.add(null)
        for (i in s..e) {
            var lst = findTree(s, i-1)
            var rst = findTree(i+1, e)
            for (j in lst.indices) {
                for (k in rst.indices) {
                    var root = TreeNode(i)
                    root.left = lst[j]
                    root.right = rst[k]
                    list.add(root)
                }
            }
        }
        return list
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S95().generateTrees(3))
        }
    }
}