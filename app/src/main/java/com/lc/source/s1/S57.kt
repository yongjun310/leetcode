package com.lc.source.s1


/*
57. Insert Interval
Medium

2549

232

Add to List

Share
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
Example 3:

Input: intervals = [], newInterval = [5,7]
Output: [[5,7]]
Example 4:

Input: intervals = [[1,5]], newInterval = [2,3]
Output: [[1,5]]
Example 5:

Input: intervals = [[1,5]], newInterval = [2,7]
Output: [[1,7]]


Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= intervals[i][0] <= intervals[i][1] <= 105
intervals is sorted by intervals[i][0] in ascending order.
newInterval.length == 2
0 <= newInterval[0] <= newInterval[1] <= 105
Accepted
323,343
Submissions
925,304
 */

class S57{
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var list = ArrayList<IntArray>()
        var curstr = -1
        var curend = -1
        for (i in intervals.indices) {
            if (curstr == -1) {
                if (newInterval[1]<intervals[i][0]) {
                    list.add(newInterval)
                    list.add(intervals[i])
                    curstr = 106
                    curend = 106
                } else if (intervals[i][1]<newInterval[0]) {
                    list.add(intervals[i])
                } else {
                    if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[1]) {
                        list.add(intervals[i])
                        curstr = 106
                        curend = 106
                    } else {
                        curstr = Math.min(intervals[i][0], newInterval[0])
                        curend = Math.max(intervals[i][1], newInterval[1])
                    }
                }
            } else {
                if (curend == 106) {
                    list.add(intervals[i])
                    continue
                }
                if (intervals[i][0] <= curend) {
                    if (intervals[i][1] > curend) {
                        curend = intervals[i][1]
                    }
                } else {
                    list.add(intArrayOf(curstr, curend))
                    list.add(intervals[i])
                    curend = 106
                }
            }
        }
        if (curstr == -1) {
            list.add(newInterval)
        } else if (curend != 106) {
            list.add(intArrayOf(curstr, curend))
        }
        return list.toTypedArray()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S57().insert(arrayOf(intArrayOf(1,5),intArrayOf(6,8)), intArrayOf(0,9)))
        }
    }
}