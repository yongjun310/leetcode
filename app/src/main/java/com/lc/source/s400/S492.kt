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
492. Construct the Rectangle
Easy

225

274

Add to List

Share
A web developer needs to know how to design a web page's size. So, given a specific rectangular web page’s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

The area of the rectangular web page you designed must equal to the given target area.
The width W should not be larger than the length L, which means L >= W.
The difference between length L and width W should be as small as possible.
Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.



Example 1:

Input: area = 4
Output: [2,2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1].
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. So the length L is 2, and the width W is 2.
Example 2:

Input: area = 37
Output: [37,1]
Example 3:

Input: area = 122122
Output: [427,286]


Constraints:

1 <= area <= 107
Accepted
59,461
Submissions
119,335
 */

class S492{
    fun constructRectangle(area: Int): IntArray {
        var arr = IntArray(2)
        var w = 1
        var l = area
        for(i in 2 until area) {
            if(area%i == 0) {
                var t = area/i
                if(t<i) {
                    break
                }
                l = t
                w = i
            }
        }
        arr[0] = l
        arr[1] = w
        return arr
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}