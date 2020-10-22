package com.lc.source.s400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
463. Island Perimeter
Easy

2328

128

Add to List

Share
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example 1:


Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.
Example 2:

Input: grid = [[1]]
Output: 4
Example 3:

Input: grid = [[1,0]]
Output: 4


Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.
Accepted
244,747
Submissions
370,146

 */

class S463{
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var c1 = 0
        var ac = 0
        for(i in grid.indices) {
            for(j in grid[0].indices) {
                if(grid[i][j] == 1) {
                    c1++
                    if(i>0 && grid[i-1][j] == 1) {
                        ac++
                    }
                    if(i<grid.size-1 && grid[i+1][j] == 1) {
                        ac++
                    }
                    if(j>0 && grid[i][j-1] == 1) {
                        ac++
                    }
                    if(j<grid[0].size-1 && grid[i][j+1] == 1) {
                        ac++
                    }
                }
            }
        }
        return c1*4 - ac
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}