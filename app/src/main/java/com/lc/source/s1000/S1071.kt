package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1071. Greatest Common Divisor of Strings
Easy

532

136

Add to List

Share
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.



Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
Example 4:

Input: str1 = "ABCDEF", str2 = "ABC"
Output: ""


Constraints:

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1 and str2 consist of English uppercase letters.
Accepted
31,014
Submissions
59,258
 */

class S1071 {
    fun containStr(str1: String, str2: String): Boolean {
        if(str1 == "" || str2 == "") {
            return false
        }
        if(str1.length % str2.length != 0) {
            return false
        }
        var n = str1.length/str2.length
        var sb = StringBuilder()
        while(n-->0) {
            sb.append(str2)
        }
        return str1.equals(sb.toString())
    }

    fun gcdOfStrings(str1: String, str2: String): String {
        var e = str1.length > str2.length
        var s = ""
        if(e) {
            s = str2
        } else {
            s = str1
        }
        var ret = ""
        var sb = StringBuilder()
        for(i in 0..s.length-1) {
            sb.append(s[i])
            var str = sb.toString()
            if(containStr(str1, str) && containStr(str2, str)) {
                ret = sb.toString()
            }
        }
        return ret
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1071().gcdOfStrings("ABCABC", "ABC"))
        }
    }

}