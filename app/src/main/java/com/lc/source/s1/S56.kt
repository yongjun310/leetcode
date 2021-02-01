package com.lc.source.s1

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
56. Merge Intervals
Medium

6361

355

Add to List

Share
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
Accepted
793,845
Submissions
1,944,889
 */

class S56{
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        var list = ArrayList<IntArray>()
        var curStr = intervals[0][0]
        var curEnd = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0]<=curEnd) {
                if (intervals[i][1] > curEnd) {
                    curEnd = intervals[i][1]
                }
            } else {
                list.add(intArrayOf(curStr, curEnd))
                curStr = intervals[i][0]
                curEnd = intervals[i][1]
            }
        }
        list.add(intArrayOf(curStr, curEnd))
        return list.toTypedArray()
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S56().merge(arrayOf(intArrayOf(1,4),intArrayOf(4,5))))
        }
    }
}