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

class S96{
    class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

    fun numTrees(n: Int): Int {
        var retl = findTree(1, n)
        return retl
    }

    fun findTree(s:Int, e:Int):Int {
        if (s>e) return 1
        var c = 0
        for (i in s..e) {
            var lst = findTree(s, i-1)
            var rst = findTree(i+1, e)
            c += lst*rst
        }
        return c
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}