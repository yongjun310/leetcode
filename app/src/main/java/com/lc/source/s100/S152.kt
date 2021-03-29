package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap

/*
152. Maximum Product Subarray
Medium

6485

211

Add to List

Share
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Accepted
460,626
Submissions
1,402,228
 */

class S152 {
    fun maxProduct(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        if (nums.size == 1) {
            return nums[0]
        }
        var cur = 1
        var flag = false
        for (i in nums.indices) {
            if (nums[i]<0) {
                if (cur > 0) {
                    if (i<nums.size-1 && nums[i+1] < 0) {
                        cur *= nums[i]
                    } else {
                        if (cur >= result && flag) {
                            result = cur
                            cur = 1
                            flag = false
                        }
                    }
                } else {
                    cur *= nums[i]
                    flag = true
                    if (cur >= result && flag) {
                        result = cur
                        cur = 1
                        flag = false
                    }
                }
            } else {
                    cur *= nums[i]
                    flag = true
                }
            }
        if (cur > result && flag) {
            result = cur
        }
        return result
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S152().maxProduct(intArrayOf(0, 2)))
        }
    }
}