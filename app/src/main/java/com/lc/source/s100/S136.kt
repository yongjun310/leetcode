package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
136. Single Number
Easy

4738

167

Add to List

Share
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

class S136 {
    class TreeNode (
            var `val`: Int = 0,
    ) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun singleNumber(nums: IntArray): Int {
        var iterator = nums.iterator()
        var ret = iterator.next()
        while (iterator.hasNext()) {
            ret = ret xor iterator.next()
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}