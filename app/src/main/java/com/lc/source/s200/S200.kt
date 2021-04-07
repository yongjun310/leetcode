package com.lc.source.s200

/*
200. Number of Islands
Medium

8090

241

Add to List

Share
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
Accepted
1,010,137
Submissions
2,040,258
 */

class S200 {
    fun numIslands(grid: Array<CharArray>): Int {
        var tags = Array(grid.size) {
            BooleanArray(grid[0].size)
        }
        var count = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == '1' && !tags[i][j]) {
                    count++
                    visit(i, j, tags, grid)
                }
            }
        }
        return count
    }

    var nerbors = arrayOf(arrayOf(-1,0), arrayOf(1, 0), arrayOf(0, 1), arrayOf(0, -1))
    private fun visit(i: Int, j: Int, tags: Array<BooleanArray>, grid: Array<CharArray>) {
        tags[i][j] = true
        for (e in nerbors) {
            var ti = i
            var tj = j
            ti += e[0]
            tj += e[1]
            if (ti>=0 && ti<=grid.size-1 && tj>=0 && tj<=grid[0].size-1 && grid[ti][tj] == '1' && !tags[ti][tj]) {
                visit(ti, tj, tags, grid)
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S200().numIslands(arrayOf(charArrayOf('1','1','0','0','0'),charArrayOf('1','1','0','0','0'),charArrayOf('0','0','1','0','0'),charArrayOf('0','0','0','1','1'))))
        }
    }
}