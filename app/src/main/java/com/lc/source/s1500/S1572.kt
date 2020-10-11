package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1572. Matrix Diagonal Sum
Easy

170

3

Add to List

Share
Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.



Example 1:


Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.
Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8
Example 3:

Input: mat = [[5]]
Output: 5


Constraints:

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100
Accepted
19,204
Submissions
24,317
 */

class S1572 {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var sum = 0
        for(i in mat.indices) {
            sum += mat[i][i]
            if(i != mat[0].size-1-i) {
                sum += mat[i][mat[0].size - 1 - i]
            }
        }
        return sum
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}