package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*


/*
74. Search a 2D Matrix
Medium

2821

190

Add to List

Share
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.


Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
Accepted
413,612
Submissions
1,101,913
 */

class S74{
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var e = matrix.size*matrix[0].size - 1
        var s = 0
        while (s<=e) {
            var m = (s+e)/2
            var i = m/matrix[0].size
            var j = m%matrix[0].size
            if (matrix[i][j]<target) {
                s = m+1
            } else if (matrix[i][j]>target){
                e = m-1
            } else {
                return true
            }
        }
        return false
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S74().searchMatrix(arrayOf(intArrayOf(0,1,2,3),intArrayOf(4,5,6,7),intArrayOf(8,10,11,12)), 10))
        }
    }
}