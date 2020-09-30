import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.HashMap

/*
1252. Cells with Odd Values in a Matrix
Easy

331

530

Add to List

Share
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.



Example 1:


Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
Example 2:


Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.


Constraints:

1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m
Accepted
45,027
Submissions
57,475
*/
class S1252{
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        var arow = Array(n, {0})
        var acol = Array(m, {0})
        for(i in indices.indices) {
            arow[indices[i][0]]++
            acol[indices[i][1]]++
        }
        var orow = 0
        var ocol = 0
        for(i in arow.indices) {
            if(arow[i]%2 == 1) {
                orow++
            }
        }
        for(i in acol.indices) {
            if(acol[i]%2 == 1) {
                ocol++
            }
        }
        return orow*(m-ocol) + ocol*(n-orow)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1252().oddCells(48, 37, arrayOf(intArrayOf(40,5))))
        }
    }
}
