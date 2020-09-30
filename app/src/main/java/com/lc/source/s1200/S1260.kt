import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1260. Shift 2D Grid
Easy

244

94

Add to List

Share
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.



Example 1:


Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
Example 2:


Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]


Constraints:

m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
Accepted
19,866
Submissions
32,278
*/
class S1260{
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        var l = k
        var ll = ArrayList<ArrayList<Int>>()
        var m = grid.size
        var n = grid[0].size
        var tarr = IntArray(m, {0})
        while(l-->0) {
            tarr[0] = grid[m-1][n-1]
            for(i in 0..m-2) {
                tarr[i+1] = grid[i][n-1]
            }
            for(i in n-2 downTo 0) {
                for (j in 0..m - 1) {
                    grid[j][i+1] = grid[j][i]
                }
            }
            for(i in 0..m-1)
                grid[i][0] = tarr[i]
        }
        for(i in 0..m-1) {
            var arr = ArrayList<Int>()
            for(j in 0..n-1) {
                arr.add(grid[i][j])
            }
            ll.add(arr)
        }
        return ll
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1260().shiftGrid(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)), 1))
        }
    }
}
