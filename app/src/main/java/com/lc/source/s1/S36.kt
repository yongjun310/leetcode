package com.lc.source.s1

/*
36. Valid Sudoku
Medium

2265

521

Add to List

Share
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.


Example 1:


Input: board =
[['5','3','.','.','7','.','.','.','.']
,['6','.','.','1','9','5','.','.','.']
,['.','9','8','.','.','.','.','6','.']
,['8','.','.','.','6','.','.','.','3']
,['4','.','.','8','.','3','.','.','1']
,['7','.','.','.','2','.','.','.','6']
,['.','6','.','.','.','.','2','8','.']
,['.','.','.','4','1','9','.','.','5']
,['.','.','.','.','8','.','.','7','9']]
Output: true
Example 2:

Input: board =
[['8','3','.','.','7','.','.','.','.']
,['6','.','.','1','9','5','.','.','.']
,['.','9','8','.','.','.','.','6','.']
,['8','.','.','.','6','.','.','.','3']
,['4','.','.','8','.','3','.','.','1']
,['7','.','.','.','2','.','.','.','6']
,['.','6','.','.','.','.','2','8','.']
,['.','.','.','4','1','9','.','.','5']
,['.','.','.','.','8','.','.','7','9']]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit or '.'.
Accepted
438,332
Submissions
871,661
 */

class S36{
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        var set = HashSet<Char>()
        for (i in 0..8) {
            set.clear()
            for (j in 0..8) {
                if (board[i][j].isDigit() && !set.add(board[i][j])) {
                    return false
                }
            }
        }
        set.clear()
        for (i in 0..8) {
            set.clear()
            for (j in 0..8) {
                if (board[j][i].isDigit() && !set.add(board[j][i])) {
                    return false
                }
            }
        }
        set.clear()
        for (k in 0..8) {
            for (i in 0..2) {
                for (j in 0..2) {
                    if (board[i+3*(k/3)][j+3*(k%3)].isDigit() && !set.add(board[i+3*(k/3)][j+3*(k%3)])) {
                        return false
                    }
                }
            }
            set.clear()
        }
        return true
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S36().isValidSudoku(arrayOf(charArrayOf('5','3','.','.','7','.','.','.','.'),charArrayOf('6','.','.','1','9','5','.','.','.'),charArrayOf('.','9','8','.','.','.','.','6','.'),charArrayOf('8','.','.','.','6','.','.','.','3'),charArrayOf('4','.','.','8','.','3','.','.','1'),charArrayOf('7','.','.','.','2','.','.','.','6'),charArrayOf('.','6','.','.','.','.','2','8','.'),charArrayOf('.','.','.','4','1','9','.','.','5'),charArrayOf('.','.','.','.','8','.','.','7','9'))))
        }
    }
}