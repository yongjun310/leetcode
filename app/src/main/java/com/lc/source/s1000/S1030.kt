package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1030. Matrix Cells in Distance Order
Easy

230

106

Add to List

Share
We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.

Additionally, we are given a cell in that matrix with coordinates (r0, c0).

Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.
  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.
    (You may return the answer in any order that satisfies this condition.)



Example 1:

Input: R = 1, C = 2, r0 = 0, c0 = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (r0, c0) to other cells are: [0,1]
Example 2:

Input: R = 2, C = 2, r0 = 0, c0 = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
Example 3:

Input: R = 2, C = 3, r0 = 1, c0 = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].


Note:

1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C
Accepted
24,371
Submissions
37,036
 */

class S1030 {
    class MyComparator : Comparator<IntArray>{
        override fun compare(o1: IntArray, o2: IntArray): Int {
            return o1[0] - o2[0]
        }
    }
    fun arrayInit() : (Int)->(IntArray) = { intArrayOf(0, 0, 0)}
    fun arrayInit2() : (Int)->(IntArray) = { intArrayOf(0, 0)}
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        var arr = Array<IntArray>(R*C, arrayInit())
        var c = 0
        for(i in 0..R-1) {
            for(j in 0..C-1) {
                arr[c++] = intArrayOf((Math.abs(i-r0) + Math.abs(j-c0)), i, j)
            }
        }
        arr.sortWith(MyComparator())
        var retArr = Array<IntArray>(R*C, arrayInit2())
        for(i in 0..retArr.size-1) {
            retArr[i][0] = arr[i][1]
            retArr[i][1] = arr[i][2]
        }
        return retArr
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1030().allCellsDistOrder(2, 3, 1, 2))
        }
    }

}