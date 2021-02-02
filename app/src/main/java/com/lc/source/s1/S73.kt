package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*


/*
73. Set Matrix Zeroes
Medium

3013

351

Add to List

Share
Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?


Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
Accepted
391,380
Submissions
885,951
 */

class S73{
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var hasRowZero = false
        var hasColumnZero = false
        for (i in matrix.indices) {
            if (matrix[i][0] == 0) {
                hasColumnZero = true
            }
        }
        for (i in matrix[0].indices) {
            if (matrix[0][i] == 0) {
                hasRowZero = true
            }
        }
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }
        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0
                }
            }
        }
        if (hasRowZero) {
            for (i in matrix[0].indices) {
                matrix[0][i] = 0
            }
        }
        if (hasColumnZero) {
            for (i in matrix.indices) {
                matrix[i][0] = 0
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S73().setZeroes(arrayOf(intArrayOf(0,1,2,0),intArrayOf(3,4,5,2),intArrayOf(1,3,1,5))))
        }
    }
}