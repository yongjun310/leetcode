package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1470. Shuffle the Array
Easy

545

64

Add to List

Share
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].



Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]


Constraints:

1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3
Accepted
91,555
Submissions
103,200
 */

class S1470 {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        var snums = IntArray(2*n)
        for(i in 0..2*n-1) {
            if(i%2 == 0) {
                snums[i] = nums[i/2]
            } else {
                snums[i] = nums[n+i/2]
            }
        }
        return snums
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}