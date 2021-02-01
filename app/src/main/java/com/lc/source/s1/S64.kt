package com.lc.source.s1


/*
64. Minimum Path Sum
Medium

4180

78

Add to List

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.



Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
Accepted
501,821
Submissions
895,993
 */

class S64{
    fun minPathSum(matrix: Array<IntArray>): Int {
        for (i in 1 until matrix.size) {
            matrix[i][0] = matrix[i-1][0] + matrix[i][0]
        }
        for (j in 1 until matrix[0].size) {
            matrix[0][j] = matrix[0][j-1] + matrix[0][j]
        }
        for (i in 1 until matrix.size)
            for (j in 1 until matrix[0].size) {
                matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + matrix[i][j]
            }
        return matrix[matrix.size-1][matrix[0].size-1]
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}