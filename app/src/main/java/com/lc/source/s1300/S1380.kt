import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1380. Lucky Numbers in a Matrix
Easy

322

31

Add to List

Share
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.



Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]


Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.
Accepted
31,411
Submissions
44,052
*/
class S1380{
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        var rmin = IntArray(matrix.size)
        var cmax = IntArray(matrix[0].size)
        for(i in matrix.indices) {
            var min = Int.MAX_VALUE
            for(j in matrix[i].indices) {
                if(min > matrix[i][j]) {
                    min = matrix[i][j]
                }
            }
            rmin[i] = min
        }
        for(j in matrix[0].indices) {
            var max = Int.MIN_VALUE
            for(i in matrix.indices) {
                if(max < matrix[i][j]) {
                    max = matrix[i][j]
                }
            }
            cmax[j] = max
        }
        var l = ArrayList<Int>()
        for(i in rmin) {
            for(j in cmax) {
                if(i == j) {
                    l.add(i)
                }
            }
        }
        return l
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1380().luckyNumbers(arrayOf(intArrayOf(3,7,8),intArrayOf(9,11,13),intArrayOf(15,16,17))))
        }
    }
}
