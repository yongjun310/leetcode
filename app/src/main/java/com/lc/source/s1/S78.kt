package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
78. Subsets
Medium

5173

109

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
Accepted
710,443
Submissions
1,097,046
 */

class S78{
    fun subsets(nums: IntArray): List<List<Int>> {
        var retList = ArrayList<List<Int>>()
        retList.add(ArrayList())
        for (i in 1..nums.size) {
            helper(nums, 0, nums.size-1, i, ArrayList(), retList)
        }
        return retList
    }


    fun helper(nums: IntArray, s: Int, e: Int, n:Int, list:ArrayList<Int>, arrayList: ArrayList<List<Int>>) {
        for (i in s..e) {
            var cl = if (list == null) ArrayList() else list.clone() as ArrayList<Int>
            cl.add(nums[i])
            if (n == 1) {
                arrayList.add(cl)
            } else {
                helper(nums,i + 1, e, n - 1, cl, arrayList)
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S78().subsets(intArrayOf(1, 2, 3)))
        }
    }
}