package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
81. Search in Rotated Sorted Array II
Medium

1892

555

Add to List

Share
You are given an integer array nums sorted in ascending order (not necessarily distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,4,4,5,6,6,7] might become [4,5,6,6,7,0,1,2,4,4]).

If target is found in the array return its index, otherwise, return -1.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104


Follow up: This problem is the same as Search in Rotated Sorted Array, where nums may contain duplicates. Would this affect the run-time complexity? How and why?
Accepted
289,182
Submissions
863,288
 */

class S81{
    fun search(nums: IntArray, target: Int): Boolean {
        return bisearch(nums, 0, nums.size-1, target)
    }

    private fun bisearch(nums: IntArray, s: Int, e: Int, target: Int): Boolean {
        var st = s
        var ed = e
        while (st<=ed) {
            var m = (st+ed)/2
            if (nums[m] == target) {
                return true
            }
            if (nums[m] < nums[ed]) {
                if (nums[m] < target && target <= nums[ed]) {
                    st = m + 1
                } else {
                    ed = m - 1
                }
            } else if (nums[m] > nums[ed]){
                if (nums[st] <= target && target < nums[m]) {
                    ed = m - 1
                } else {
                    st = m + 1
                }
            } else {
                ed--
            }
        }
        return false
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S81().search(intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1), 2))
        }
    }
}