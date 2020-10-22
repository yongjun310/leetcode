package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
228. Summary Ranges
Easy

712

555

Add to List

Share
You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b


Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Example 3:

Input: nums = []
Output: []
Example 4:

Input: nums = [-1]
Output: ["-1"]
Example 5:

Input: nums = [0]
Output: ["0"]


Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
Accepted
175,583
Submissions
438,848
 */

class S228 {
    fun summaryRanges(nums: IntArray): List<String> {
        var list = ArrayList<String>()
        if (nums.isEmpty()) {
            return list
        }
        if(nums.size==1) {
            list.add(nums[0].toString())
        }
        var low = nums[0]
        var last = low
        for(i in 1 until nums.size) {
            if(nums[i] != last+1) {
                var sb = StringBuilder()
                sb.append(low)
                if(low != last) {
                    sb.append("->")
                    sb.append(last)
                }
                list.add(sb.toString())
                if(i != nums.size-1) {
                    low = nums[i]
                    last = low
                } else {
                    list.add(nums[i].toString())
                }
            } else {
                last = nums[i]
                if(i == nums.size-1) {
                    var sb = StringBuilder()
                    sb.append(low)
                    if(low != last) {
                        sb.append("->")
                        sb.append(last)
                    }
                    list.add(sb.toString())
                }
            }
        }
        return list
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S228().summaryRanges(intArrayOf(0,2,3,4,6,8,9)))
        }
    }
}