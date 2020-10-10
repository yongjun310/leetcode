package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1556. Thousand Separator
Easy

107

8

Add to List

Share
Given an integer n, add a dot (".") as the thousands separator and return it in string format.



Example 1:

Input: n = 987
Output: "987"
Example 2:

Input: n = 1234
Output: "1.234"
Example 3:

Input: n = 123456789
Output: "123.456.789"
Example 4:

Input: n = 0
Output: "0"


Constraints:

0 <= n < 2^31
Accepted
14,198
Submissions
23,972
 */

class S1556 {
    fun thousandSeparator(n: Int): String {
        var sb = StringBuilder()
        var m = n
        if(n == 0) {
            sb.append('0')
        }
        while(m>0) {
            var r = m%1000
            sb.insert(0, r)
            m /= 1000
            if(r<100 && r>=10 && m>0) {
                sb.insert(0, '0')
            }
            if(r<10 && m>0) {
                sb.insert(0, "00")
            }
            if(m>0) {
                sb.insert(0, '.')
            }
        }
        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}