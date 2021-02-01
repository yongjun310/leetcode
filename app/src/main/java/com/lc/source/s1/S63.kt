package com.lc.source.s1


/*
63. Unique Paths II
Medium

2401

275

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.



Example 1:


Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:


Input: obstacleGrid = [[0,1],[0,0]]
Output: 1


Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
Accepted
346,460
Submissions
984,798
 */

class S63{
    fun uniquePathsWithObstacles(matrix: Array<IntArray>): Int {
        if (matrix[0][0] == 1 || matrix[matrix.size-1][matrix[0].size-1] == 1) {
            return 0
        }
        var cur = 1
        for (i in 0 until matrix.size) {
            if (matrix[i][0] == 1) {
                cur = 0
            }
            matrix[i][0] = cur
        }
        cur = 1
        for (j in 1 until matrix[0].size) {
            if (matrix[0][j] == 1) {
                cur = 0
            }
            matrix[0][j] = cur
        }
        for (i in 1 until matrix.size)
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1]
                }
            }
        return matrix[matrix.size-1][matrix[0].size-1]
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}