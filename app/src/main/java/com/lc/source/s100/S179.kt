package com.lc.source.s100

import java.util.*

/*
179. Largest Number
Medium

2909

309

Add to List

Share
Given a list of non-negative integers nums, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:

Input: nums = [1]
Output: "1"
Example 4:

Input: nums = [10]
Output: "10"


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
Accepted
243,104
Submissions
789,093
 */

class S179 {
    class MyComparator : Comparator<Int>{
        override fun compare(o1: Int?, o2: Int?): Int {
            var ostr1 = o1.toString()
            var ostr2 = o2.toString()
            var count = 0
            while (count<ostr1.length && count<ostr2.length) {
                if (ostr1[count] != ostr2[count]) {
                    return ostr1[count] - ostr2[count]
                }
                count++
            }
            return ostr2.length - ostr1.length
        }

    }
    fun largestNumber(nums: IntArray): String {
        var retSB = StringBuilder()
        nums.sortedWith(MyComparator())
        for (i in nums.indices) {
            if (i<nums.size-1) {
                var v1len = nums[i]
                if (nums[i] )
            }
        }
    }

}
