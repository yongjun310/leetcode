package com.lc.source.s1

import java.lang.StringBuilder
import kotlin.math.min

/*
43. Multiply Strings
Medium

2212

936

Add to List

Share
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
Accepted
343,201
Submissions
986,306
 */

class S43{
    fun multiply(num1: String, num2: String): String {
        var mc = StringBuilder()
        var sb = StringBuilder()
        for (i in num1.length-1 downTo 0) {
            mc = add(mc, multiplyChar(num1[i], num2).append(sb).toString())
            sb.append("0")
        }
        return mc.toString()
    }

    private fun add(m1: StringBuilder, m2: String): StringBuilder {
        var sb = StringBuilder()
        var l1 = m1.length
        var l2 = m2.length
        var plus = 0
        var sum = 0
        var l = min(l1, l2)
        for (i in 1..l) {
            sum = m1[l1-i].toInt() - 48 + m2[l2-i].toInt() - 48 + plus
            sb.append(sum%10)
            plus = sum/10
        }
        if (l1>l2) {
            for (i in l2+1..l1) {
                sum = m1[l1-i].toInt() - 48 + plus
                sb.append(sum%10)
                plus = sum/10
            }
        } else if(l2>l1) {
            for (i in l1+1..l2) {
                sum = m2[l2-i].toInt() - 48 + plus
                sb.append(sum%10)
                plus = sum/10
            }
        }
        return sb.reverse()
    }

    private fun multiplyChar(c: Char, num2: String): StringBuilder {
        var sb = StringBuilder()
        var plus = 0
        var sum = 0
        for (i in num2.length-1 downTo 0) {
            sum = plus + (num2[i].toInt()-48) * (c.toInt() - 48)
            sb.append(sum%10)
            plus = sum/10
        }
        sb.reverse()
        return sb
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S43().multiply("232", "332"))
        }
    }
}