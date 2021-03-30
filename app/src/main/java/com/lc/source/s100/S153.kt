package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*
153. Find Minimum in Rotated Sorted Array
Medium

3274

296

Add to List

Share
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.


Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
Accepted
572,036
Submissions
1,235,357
 */

class S153 {
    fun findMin(nums: IntArray): Int {
        return helper(nums, 0, nums.size-1)
    }

    private fun helper(nums: IntArray, start: Int, end: Int): Int {
        if (start == end) {
            return nums[start]
        }
        var mid = (start+end)/2
        if (nums[mid] < nums[end]) {
            return helper(nums, start, mid)
        } else {
            return helper(nums, mid+1, end)
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S153().findMin(intArrayOf(3,4,5,1,2)))
        }
    }
}