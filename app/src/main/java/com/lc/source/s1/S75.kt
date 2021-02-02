package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*


/*
75. Sort Colors
Medium

4767

272

Add to List

Share
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.


Follow up:

Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?
Accepted
622,074
Submissions
1,266,134
 */

class S75{
    fun sortColors(nums: IntArray): Unit {
        var c0 = 0
        var c1 = 0
        var c2 = 0
        for (i in nums.indices) {
            when(nums[i]) {
                0 -> c0++
                1 -> c1++
                2 -> c2++
            }
        }
        c1 += c0
        c2 += c1
        for (i in nums.indices) {
            if (i<c0) {
                nums[i] = 0
                if (i == c0-1) {
                    c0 = -1
                }
            } else if (i<c1) {
                nums[i] = 1
                if (i == c1-1) {
                    c1 = -1
                }
            } else if (i<c2) {
                nums[i] = 2
                if (i == c2-1) {
                    c2 = -1
                }
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}