package com.lc.source.s1

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
55. Jump Game
Medium

5632

393

Add to List

Share
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105
Accepted
579,315
Submissions
1,650,604
 */

class S55{
    fun canJump(nums: IntArray): Boolean {
        return helper(nums, 0)
    }

    fun helper(nums: IntArray, index: Int): Boolean {
        if (index == nums.size-1) {
            return true
        }
        if (nums[index] == 0) {
            return false
        }
        if (nums.size-1>index && nums[index] == nums[index+1]+1) {
            return helper(nums, index+1)
        }
        var ret = false
        for (i in 1..nums[index]) {
            ret = ret || helper(nums, index+i)
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S55().canJump(intArrayOf(3,2,1,0,4)))
        }
    }
}