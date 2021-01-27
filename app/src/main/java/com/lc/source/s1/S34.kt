package com.lc.source.s1

import java.lang.StringBuilder
import java.util.Collections.binarySearch
import java.util.Collections.sort
import kotlin.collections.ArrayList

/*
34. Find First and Last Position of Element in Sorted Array
Medium

4831

185

Add to List

Share
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
Accepted
634,763
Submissions
1,708,265
 */

class S34{
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var retA = IntArray(2)
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        retA[0] = bisearch(nums, target-0.1f) + 1
        retA[1] = bisearch(nums, target+0.1f)
        if(retA[0]>retA[1]) {
            retA[0] = -1
            retA[1] = -1
        }
        return retA
    }

    fun bisearch(nums: IntArray, target: Float):Int {
        var low = 0
        var high = nums.size-1
        var mid = 0
        while (low<high) {
            mid = (low+high)/2
            if (nums[mid]>target) {
                high = mid-1
            } else {
                low = mid+1
            }
        }
        return if (nums[low]>target) low-1 else low
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var arr = S34().searchRange(intArrayOf(5,7,7,7,7,7,8,8,10), 8)
            print("start:" + arr[0] + " end:" + arr[1])
        }
    }
}