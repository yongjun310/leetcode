package com.lc.source.s1

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
54. Spiral Matrix
Medium

3402

633

Add to List

Share
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
Accepted
455,546
Submissions
1,275,925
 */

class S54{
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var list = ArrayList<Int>()
        helper(matrix, 0, matrix.size-1, 0, matrix[0].size-1, list)
        return list
    }

    fun helper(matrix: Array<IntArray>, rs: Int, re: Int, cs:Int, ce: Int, list: ArrayList<Int>) {
        if (matrix.isNotEmpty()) {
            for (i in cs..ce) {
                list.add(matrix[rs][i])
            }
        }
        if (re == rs) {
            return
        }
        for (j in rs+1..re) {
            list.add(matrix[j][ce])
        }
        if (cs == ce) {
            return
        }
        for (j in ce-1 downTo cs) {
            list.add(matrix[re][j])
        }
        for (j in re-1 downTo rs+1) {
            list.add(matrix[j][rs])
        }
        if (rs+1<=re-1 && cs+1<=ce-1)
        helper(matrix, rs+1, re-1, cs+1, ce-1, list)
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S54().spiralOrder(arrayOf(intArrayOf(1,2),intArrayOf(3,4))))
        }
    }
}