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
461. Hamming Distance
Easy

1957

167

Add to List

Share
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
Accepted
367,959
Submissions
504,294


 */

class S461{
    fun hammingDistance(x: Int, y: Int): Int {
        var or = x xor y
        var c = 0
        while(or>0) {
            c += or and 1
            or = or shr 1
        }
        return c
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}