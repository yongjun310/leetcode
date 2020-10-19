package com.lc.source.s300

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
392. Is Subsequence
Easy

1854

216

Add to List

Share
Given a string s and a string t, check if s is subsequence of t.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 10^4
Both strings consists only of lowercase characters.
Accepted
244,465
Submissions
494,910
 */

class S392{
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while(i<s.length && j<t.length) {
            if(s[i] == t[j]) {
                i++
                j++
            } else {
                j++
            }
        }
        return i==s.length
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}