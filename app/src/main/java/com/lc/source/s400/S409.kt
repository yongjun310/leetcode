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
409. Longest Palindrome
Easy

1311

92

Add to List

Share
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.



Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2


Constraints:

1 <= s.length <= 2000
s consits of lower-case and/or upper-case English letters only.
Accepted
180,852
Submissions
348,279
 */

class S409{
    fun longestPalindrome(s: String): Int {
        var arr = IntArray(52)
        for(i in s.indices) {
            if(s[i]>='a') {
                arr[s[i]-'a'+26]++
            } else {
                arr[s[i]-'A']++
            }
        }
        var hasS = false
        var ret = 0
        for(e in arr) {
            if(e and 1 == 1 && !hasS) {
                ret += e
                hasS = true
            } else {
                ret += e/2 * 2
            }
        }
        return ret
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S409().longestPalindrome("aaaAaaaa"))
        }
    }
}