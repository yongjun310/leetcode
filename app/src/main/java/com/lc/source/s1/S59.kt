package com.lc.source.s1


/*
59. Spiral Matrix II
Medium

1511

125

Add to List

Share
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.



Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]


Constraints:

1 <= n <= 20
Accepted
239,371
Submissions
415,782
 */

class S59{

    fun helper(matrix: Array<IntArray>, rs: Int, re: Int, cs:Int, ce: Int, start: Int) {
        var count = start
        if (matrix.isNotEmpty()) {
            for (i in cs..ce) {
                matrix[rs][i] = count++
            }
        }
        if (re == rs) {
            return
        }
        for (j in rs+1..re) {
            matrix[j][ce] = count++
        }
        if (cs == ce) {
            return
        }
        for (j in ce-1 downTo cs) {
            matrix[re][j] = count++
        }
        for (j in re-1 downTo rs+1) {
            matrix[j][rs] = count++
        }
        if (rs+1<=re-1 && cs+1<=ce-1)
            helper(matrix, rs+1, re-1, cs+1, ce-1, count)
    }

    fun generateMatrix(n: Int): Array<IntArray> {
        var matrix = Array(n) { IntArray(n) }
        helper(matrix, 0, n-1, 0, n-1, 1)
        return matrix
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}