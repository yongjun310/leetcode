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
        if (n == 0) return 0
        if (n == 1) return 1
        var nums = IntArray(n+1)
        nums[0] = 1
        nums[1] = 1
        for (i in 2..n) {
            for (j in 0 until i) {
                nums[i] += nums[j]*nums[i-1-j]
            }
        }
        return nums[n]
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S96().numTrees(3))
        }
    }
}