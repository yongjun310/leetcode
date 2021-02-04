package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
90. Subsets II
Medium

2222

99

Add to List

Share
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
Accepted
322,569
Submissions
662,811
 */

class S90{
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        var retList = ArrayList<List<Int>>()
        retList.add(ArrayList())
        for (i in 1..nums.size) {
            helper(nums, 0, nums.size-1, i, ArrayList(), retList)
        }
        return retList.toList()
    }


    fun helper(nums: IntArray, s: Int, e: Int, n:Int, list:ArrayList<Int>, arrayList: ArrayList<List<Int>>) {
        var cur = 11
        for (i in s..e) {
            if (nums[i] == cur) {
                continue
            }
            var cl = if (list == null) ArrayList() else list.clone() as ArrayList<Int>
            cl.add(nums[i])
            cur = nums[i]
            if (n == 1) {
                arrayList.add(cl)
            } else {
                helper(nums,i + 1, e, n - 1, cl, arrayList)
            }
        }
    }
//    [[1], [4, 4, 1], [], [4, 4], [4], [4, 4, 4], [1, 4], [4, 1, 4], [4, 4, 4, 1, 4], [4, 4, 1, 4], [4, 4, 4, 4], [4, 4, 4, 1], [4, 1]]
//    [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S90().subsetsWithDup(intArrayOf(1,4,4,4,4)))
        }
    }
}