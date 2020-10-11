package com.lc.source.s1600

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet
import kotlin.math.log

/*
1608. Special Array With X Elements Greater Than or Equal X
Easy

112

15

Add to List

Share
You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.

Notice that x does not have to be an element in nums.

Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.



Example 1:

Input: nums = [3,5]
Output: 2
Explanation: There are 2 values (3 and 5) that are greater than or equal to 2.
Example 2:

Input: nums = [0,0]
Output: -1
Explanation: No numbers fit the criteria for x.
If x = 0, there should be 0 numbers >= x, but there are 2.
If x = 1, there should be 1 number >= x, but there are 0.
If x = 2, there should be 2 numbers >= x, but there are 0.
x cannot be greater since there are only 2 numbers in nums.
Example 3:

Input: nums = [0,4,3,0,4]
Output: 3
Explanation: There are 3 values that are greater than or equal to 3.
Example 4:

Input: nums = [3,6,7,7,0]
Output: -1


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
Accepted
10,432
Submissions
16,523
 */

class S1608 {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        for(i in 0..nums.size) {
            var j = nums.size-i
            if(j>nums.size-1) {
                if(nums[nums.size-1] < 0) {
                    return i
                }
                continue
            }
            if(j == 0 && nums[0] >= i) {
                return i
                continue
            }
            if(nums[j]>=i && nums[j-1] < i) {
                return i
            }
        }
        return -1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1608().specialArray(intArrayOf(0,4,3,0,4)))
        }
    }
}