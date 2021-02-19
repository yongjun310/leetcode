package com.lc.sword.offer

import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList

/*
剑指 Offer 04. 二维数组中的查找
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。



限制：

0 <= n <= 1000

0 <= m <= 1000



注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

通过次数135,887提交次数331,553
 */

class S4 {
    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty() || matrix[0].isEmpty()) {
            return false
        }
        return findNum(matrix, 0, matrix.size-1, 0, matrix[0].size-1, target)
    }

    fun findNum(matrix: Array<IntArray>, rs:Int, re:Int, cs:Int, ce:Int, target:Int): Boolean {
        if (rs == re) {
            for (i in cs..ce) {
                if (matrix[rs][i] == target) {
                    return true
                }
            }
            return false
        }
        if (cs == ce) {
            for (i in rs..re) {
                if (matrix[i][cs] == target) {
                    return true
                }
            }
            return false
        }
        if (target < matrix[rs][cs] || target > matrix[re][ce]) {
            return false
        }
        if ((ce-cs)>=(re-rs)) {
            for (i in rs..re) {
                var cc = cs + (i - rs + 1) * (ce + 1 - cs) / (re + 1 - rs) - 1
                if (matrix[i][cc] > target) {
                    return findNum(matrix, i, re, cs, cc - 1, target) || findNum(matrix, rs, i - 1, cc, ce, target)
                } else if (matrix[i][cc] == target) {
                    return true
                }
            }
        } else {
            for (i in cs..ce) {
                var cc = rs + (i-cs+1) * (re+1-rs) / (ce + 1 - cs) - 1
                if (matrix[cc][i] > target) {
                    return findNum(matrix, (i-1-cs) * (re+1-rs) / (ce + 1 - cs)+1, re, cs, i-1, target) || findNum(matrix, rs, cc-1, i, ce, target)
                } else if (matrix[cc][i] == target) {
                    return true
                }
            }
        }
        return false
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S4().findNumberIn2DArray(arrayOf(intArrayOf(1,3,5,7,9), intArrayOf(2,4,6,8,10),
                    intArrayOf(11,13,15,17,19), intArrayOf(12,14,16,18,20), intArrayOf(21,22,23,24,25)), 8))
//            print(S4().findNumberIn2DArray(arrayOf(intArrayOf(1,   4), intArrayOf(2,   5)), 0))
        }
    }
}