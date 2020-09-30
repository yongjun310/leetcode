package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1042. Flower Planting With No Adjacent
Easy

373

437

Add to List

Share
You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.



Example 1:

Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]
Example 2:

Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]
Example 3:

Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]


Note:

1 <= N <= 10000
0 <= paths.size <= 20000
No garden has 4 or more paths coming into or leaving it.
It is guaranteed an answer exists.
Accepted
30,107
Submissions
62,264
 */

class S1042 {
    class Graphic (var `val`:Int, var arr:IntArray){
    }

    fun arrayInit() : (Int)->(Graphic) = { Graphic(0, IntArray(4))}
    fun gardenNoAdj(N: Int, paths: Array<IntArray>): IntArray {
        var gl = Array(N, arrayInit())
        for(i in 0..paths.size-1) {
            gl[i]
        }
        return intArrayOf()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}