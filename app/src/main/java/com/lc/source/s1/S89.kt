package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


/*
89. Gray Code
Medium

768

1719

Add to List

Share
The gray code is a binary numeral system where two successive values differ in only one bit.

Given an integer n representing the total number of bits in the code, return any sequence of gray code.

A gray code sequence must begin with 0.



Example 1:

Input: n = 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2
[0,2,3,1] is also a valid gray code sequence.
00 - 0
10 - 2
11 - 3
01 - 1
Example 2:

Input: n = 1
Output: [0,1]


Constraints:

1 <= n <= 16
Accepted
174,866
Submissions
348,121
 */

class S89{
    fun grayCode(n: Int): List<Int> {
        var list = ArrayList<Int>()
        list.add(0)
        list.add(1)
        var b = 1
        for (i in 1 until n) {
            b *= 2
            var s = list.size - 1
            for (i in s downTo 0) {
                list.add(b + list[i])
            }
        }
        return list
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S89().grayCode(2))
        }
    }
}