package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1464. Maximum Product of Two Elements in an Array
Easy

233

59

Add to List

Share
Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).


Example 1:

Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:

Input: nums = [3,7]
Output: 12


Constraints:

2 <= nums.length <= 500
1 <= nums[i] <= 10^3
Accepted
47,885
Submissions
61,616
 */

class S1464 {
    fun maxProduct(nums: IntArray): Int {
        var max = 0
        var submax = 0
        for(i in 0..nums.size-1) {
            if(max < nums[i]) {
                submax = max
                max = nums[i]
            } else if(submax < nums[i]) {
                submax = nums[i]
            }
        }
        return (max-1) * (submax-1)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}