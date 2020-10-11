package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1582. Special Positions in a Binary Matrix
Easy

136

6

Add to List

Share
Given a rows x cols matrix mat, where mat[i][j] is either 0 or 1, return the number of special positions in mat.

A position (i,j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).



Example 1:

Input: mat = [[1,0,0],
              [0,0,1],
              [1,0,0]]
Output: 1
Explanation: (1,2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
Example 2:

Input: mat = [[1,0,0],
              [0,1,0],
              [0,0,1]]
Output: 3
Explanation: (0,0), (1,1) and (2,2) are special positions.
Example 3:

Input: mat = [[0,0,0,1],
              [1,0,0,0],
              [0,1,1,0],
              [0,0,0,0]]
Output: 2
Example 4:

Input: mat = [[0,0,0,0,0],
              [1,0,0,0,0],
              [0,1,0,0,0],
              [0,0,1,0,0],
              [0,0,0,1,1]]
Output: 3


Constraints:

rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] is 0 or 1.
Accepted
13,844
Submissions
21,539
 */

class S1582 {
    fun numSpecial(mat: Array<IntArray>): Int {
        var c = 0
        for(i in mat.indices) {
            var k = 0
            var col = 0
            for(j in mat[0].indices) {
                if(mat[i][j] == 1) {
                    k++
                    col = j
                }
            }
            if(k == 1) {
                var h = true
                for(k in mat.indices) {
                    if(mat[k][col] == 1 && i != k) {
                        h = false
                    }
                }
                if(h) {
                    c++
                }
            }
        }
        return c
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}