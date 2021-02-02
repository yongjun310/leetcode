package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
81. Search in Rotated Sorted Array II
Medium

1892

555

Add to List

Share
You are given an integer array nums sorted in ascending order (not necessarily distinct values), and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,4,4,5,6,6,7] might become [4,5,6,6,7,0,1,2,4,4]).

If target is found in the array return its index, otherwise, return -1.



Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104


Follow up: This problem is the same as Search in Rotated Sorted Array, where nums may contain duplicates. Would this affect the run-time complexity? How and why?
Accepted
289,182
Submissions
863,288
 */

class S801{
    fun isIp(ipStr:String) : Boolean{

        for (i in ipStr.indices) {
            if (!(ipStr[i].isDigit() || ipStr[i] == '.')) {
                return false
            }
        }
        var list = ipStr.split(".")
        if (list.size != 4) {
            return false
        }
        for (i in list.indices) {
            if (list[i].length>3 || list[i].isEmpty()) {
                return false
            }
            var intValue = list[i].toInt()
            if (intValue>255) {
                return false
            }
        }
        return true
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            println(S801().isIp("10.123.12.256"))
            println(S801().isIp("10..123.12.256"))
            println(S801().isIp("a10.123.12.256"))
            println(S801().isIp("10.123.12.25"))
            println(S801().isIp("10.123.12.25.23"))
            println(S801().isIp("10.123.12.2e56"))
            println(S801().isIp("10dfq.adfj9.fwefaa.256"))
        }
    }
}