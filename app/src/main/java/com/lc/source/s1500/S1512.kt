package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1512. Number of Good Pairs
Easy

553

45

Add to List

Share
Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100
Accepted
74,707
Submissions
84,712
 */

class S1512 {
    fun numIdenticalPairs(nums: IntArray): Int {
        nums.sort()
        var ret = 0
        var c = 1
        var last = nums[0]
        for(i in 1 until nums.size) {
            if(nums[i] == last) {
                c++
            } else {
                if(c>1) {
                    ret += c*(c-1)/2
                }
                c = 1
                last = nums[i]
            }
        }
        if(c>1) {
            ret += c*(c-1)/2
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}