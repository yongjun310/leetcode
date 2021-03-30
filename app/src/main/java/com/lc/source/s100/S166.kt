package com.lc.source.s100

import java.util.*

/*
166. Fraction to Recurring Decimal
Medium

1105

2229

Add to List

Share
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.



Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"


Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0
Accepted
147,954
Submissions
661,148
 */

class S166 {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        var nplus = numerator>=0
        var denplus= denominator>0
        var menus = false
        if (nplus && !denplus || !nplus && denplus) {
            menus = true
        }

        var sb = StringBuilder()
        var num = numerator.toLong()
        if (!nplus) {
            num = 0L-numerator
        }
        var denum = denominator.toLong()
        if (!denplus) {
            denum = -denum
        }
        if (menus && num != 0L) {
            sb.append('-')
        }
        if (num>=denum) {
            sb.append(num / denum)
            num %= denum
        } else {
            sb.append('0')
        }
        if (num != 0L) {
            sb.append('.')
        }
        var hasplus = false
        var plusLength = sb.length
        var numlist = ArrayList<Long>()
        while (num != 0L) {
            num *= 10
            numlist.add(num)
            var newdev = num/denum
            if (newdev>0 && !hasplus) {
                hasplus = true
            }
            var lastIndex = sb.indexOf(newdev.toString(), plusLength)
            if (lastIndex > 0 && hasplus && numlist[lastIndex - plusLength] == num) {
                sb.insert(lastIndex, '(')
                sb.append(')')
                break
            }
            num %= denum
            sb.append(newdev)
        }
        return sb.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S166().fractionToDecimal(-1, -2147483648))
        }
    }
}