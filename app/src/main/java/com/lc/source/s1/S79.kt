package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
79. Word Search
Medium

5119

221

Add to List

Share
Given an m x n board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 200
1 <= word.length <= 103
board and word consists only of lowercase and uppercase English letters.
Accepted
601,006
Submissions
1,638,867
 */

class S79{
    fun exist(board: Array<CharArray>, word: String): Boolean {
        var used = Array(board.size){BooleanArray(board[0].size) }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if(search(board, i, j, used, word, 0)) {
                    return true
                }
            }
        }
        return false
    }

    fun search(board: Array<CharArray>, i: Int, j: Int, used: Array<BooleanArray>, word:String, c:Int) : Boolean {
        var searchPath = arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(0,-1),intArrayOf(-1,0))
        if (board[i][j] == word[c]) {
            used[i][j] = true
            if (c == word.length-1) {
                return true
            }
            var ret = false
            for (k in searchPath.indices) {
                var ni = i+searchPath[k][0]
                var nj = j+searchPath[k][1]
                if (ni>=0 && nj>=0 && ni<board.size && nj<board[0].size && !used[ni][nj]) {
                    ret = ret || search(board, ni, nj, used, word, c + 1)
                }
            }
            if (ret) {
                return true
            }
        }
        used[i][j] = false
        return false
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S79().exist(arrayOf(charArrayOf('a','a','a','a'),charArrayOf('a','a','a','a'),charArrayOf('a','a','a','a')), "aaaaaaaaaaaaa"))
        }
    }
}