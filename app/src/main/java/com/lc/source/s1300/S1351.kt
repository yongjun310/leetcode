import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1351. Count Negative Numbers in a Sorted Matrix
Easy

566

33

Add to List

Share
Given a m * n matrix grid which is sorted in non-increasing order both row-wise and column-wise.

Return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.
Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0
Example 3:

Input: grid = [[1,-1],[-1,-1]]
Output: 3
Example 4:

Input: grid = [[-1]]
Output: 1


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
Accepted
69,333
Submissions
90,833
*/
class S1351{
    fun countNegatives(grid: Array<IntArray>): Int {
        var c = grid[0].size
        var r = grid.size
        var m = r - 1
        var n = 0
        var ret = 0
        while(m>=0 && n<c) {
            if(grid[m][n]<0) {
                ret += c - n
                m--
            } else {
                n++
            }
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1351().countNegatives(arrayOf(intArrayOf(4,3,2,-1), intArrayOf(3,2,1,-1), intArrayOf(1,1,-1,-2), intArrayOf(-1,-1,-2,-3))))
        }
    }
}
