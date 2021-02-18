package com.lc.source.s100

import java.util.*
import java.util.concurrent.LinkedBlockingQueue

/*
120. Triangle
Medium

2614

296

Add to List

Share
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10


Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104


Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
Accepted
283,829
Submissions
621,500
 */

class S120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        var tempRow = IntArray(triangle.size, {0})
        var min = Integer.MAX_VALUE
        tempRow[0] = triangle[0][0]
        var last = 0
        var cur = 0
        if (triangle.size == 1) {
            return triangle[0][0]
        }
        for (i in 1 until triangle.size) {
            for (j in triangle[i].indices) {
                cur = tempRow[j]
                if (j == 0) {
                    tempRow[j] = tempRow[j] + triangle[i][j]
                } else if (j == triangle[i].size-1) {
                    tempRow[j] = last + triangle[i][j]
                } else {
                    tempRow[j] = Math.min(last + triangle[i][j], cur + triangle[i][j])
                }
                if (i == triangle.size-1 && tempRow[j] < min) {
                    min = tempRow[j]
                }
                last = cur
            }
        }
        return min
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S120().minimumTotal(listOf(listOf(-10))))
        }
    }
}