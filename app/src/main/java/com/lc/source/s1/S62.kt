package com.lc.source.s1


/*
62. Unique Paths
Medium

4485

235

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
Example 3:

Input: m = 7, n = 3
Output: 28
Example 4:

Input: m = 3, n = 3
Output: 6


Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 109.
Accepted
589,203
Submissions
1,056,312
 */

class S62{
    fun uniquePaths(m: Int, n: Int): Int {
        var matrix = Array<IntArray>(m){IntArray(n)}
        for (i in 0 until m) {
            matrix[i][0] = 1
        }
        for (j in 0 until n) {
            matrix[0][j] = 1
        }
        for (i in 1 until m)
            for (j in 1 until n) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]
            }
        return matrix[m-1][n-1]
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S62().uniquePaths(51,9))
        }
    }
}