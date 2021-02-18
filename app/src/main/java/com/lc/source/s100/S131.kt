package com.lc.source.s100

import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList

/*
131. Palindrome Partitioning
Medium

3009

96

Add to List

Share
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]


Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
Accepted
294,422
Submissions
567,441
 */

class S131 {
    fun partition(s: String): List<List<String>> {
        var retArr = ArrayList<ArrayList<String>>()
        if (s.length == 1 || isPalindrome(s)) {
            var list = ArrayList<String>()
            list.add(s)
            retArr.add(list)
        }
        for (i in 1 until s.length) {
            if (isPalindrome(s.substring(0, i))) {
                var subList = partition(s.substring(i))
                for (e in subList) {
                    (e as ArrayList).add(0, s.substring(0, i))
                    retArr.add(e)
                }
            }
        }
        return retArr
    }

    fun isPalindrome(s: String):Boolean {
        var half = s.length/2 - 1
        for (i in 0..half) {
            if (s[i] != s[s.length-1-i]) {
                return false
            }
        }
        return true
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S131().partition("aabb"))
        }
    }
}