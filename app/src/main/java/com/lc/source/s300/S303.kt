package com.lc.source.s300

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.min

/*
303. Range Sum Query - Immutable
Easy

1030

1195

Add to List

Share
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int i, int j) Return the sum of the elements of the nums array in the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j]))


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))


Constraints:

0 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= i <= j < nums.length
At most 104 calls will be made to sumRange.
Accepted
221,177
Submissions
482,006
 */

class S303{
    var nums: IntArray
    lateinit var sumArr: IntArray
    constructor(nums: IntArray) {
        this.nums = nums
        sumArr = IntArray(nums.size)
        if(nums.size>0) {
            sumArr[0] = nums[0]
        }
        for(i in 1 until nums.size) {
            sumArr[i] = sumArr[i-1] + nums[i]
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sumArr[j] - sumArr[i] + nums[i]
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}