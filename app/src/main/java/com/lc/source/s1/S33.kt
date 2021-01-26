package com.lc.source.s1

import java.lang.StringBuilder
import java.util.Collections.binarySearch
import java.util.Collections.sort
import kotlin.collections.ArrayList

/*
33. Search in Rotated Sorted Array
Medium

6763

600

Add to List

Share
You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
Accepted
900,316
Submissions
2,522,022
 */

class S33{
    fun search(nums: IntArray, target: Int): Int {
        var s = 0
        for (i in 1 until nums.size) {
            if (nums[i-1]>nums[i]) {
                s = i
            }
        }
        if (s == 0) {
            s = nums.size
        }
        var s1 = nums.binarySearch(target, 0, s)
        if (s1>=0) {
            return s1
        } else {
            s1 = nums.binarySearch(target, s)
            if (s1<0) {
                s1 = -1
            }
            return s1
        }
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S33().search(intArrayOf(1), 1))
        }
    }
}