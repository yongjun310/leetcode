package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1441. Build an Array With Stack Operations
Easy

171

231

Add to List

Share
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.



Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation:
Read number 1 and automatically push in the array -> [1]
Read number 2 and automatically push in the array then Pop it -> [1]
Read number 3 and automatically push in the array -> [1,3]
Example 2:

Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]
Example 3:

Input: target = [1,2], n = 4
Output: ["Push","Push"]
Explanation: You only need to read the first 2 numbers and stop.
Example 4:

Input: target = [2,3,4], n = 4
Output: ["Push","Pop","Push","Push","Push"]


Constraints:

1 <= target.length <= 100
1 <= target[i] <= 100
1 <= n <= 100
target is strictly increasing.
 */

class S1441 {
    fun buildArray(target: IntArray, n: Int): List<String> {
        var list = ArrayList<String>()
        var index = 0
        var cur = target[index]
        for(i in 1..n) {
            if(i<cur && index < target.size) {
                list.add("Push")
                list.add("Pop")
            } else if(i==cur) {
                list.add("Push")
                index++
                if(index<target.size) {
                    cur = target[index]
                } else {
                    cur = 101
                }
            }
        }
        return list
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}