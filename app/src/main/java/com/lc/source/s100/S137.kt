package com.lc.source.s100

import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue

/*
137. Single Number II
Medium

2427

399

Add to List

Share
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99


Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.


Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Accepted
279,419
Submissions
518,092
 */

class S137 {
    fun singleNumber(nums: IntArray): Int {
        var r = nums[0]
        for (i in 1 until nums.size) {
            r = r xor nums[i]
        }
        return -r.inv()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(S137().singleNumber(intArrayOf(0,1,0,1,0,1,199)))
            print(S137().singleNumber(intArrayOf(2,2,3,2)))
        }
    }
}