package com.lc.source.s1

import kotlin.collections.ArrayList


/*
97. Interleaving String
Medium

1912

105

Add to List

Share
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.



Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true


Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.


Follow up: Could you solve it using only O(s2.length) additional memory space?

Accepted
176,979
Submissions
541,712
 */

class S97{
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) {
            return false
        }
        if (s1.isEmpty() && s2.isEmpty()) {
            return true
        } else if (s1.isEmpty()) {
            return s2 == s3
        } else if (s2.isEmpty()) {
            return s1 == s3
        }
        if (s1[0] == s3[0] && s2[0] != s3[0]) {
            return isInterleave(s1.substring(1), s2, s3.substring(1))
        } else if (s2[0] == s3[0] && s1[0] != s3[0]) {
            return isInterleave(s1, s2.substring(1), s3.substring(1))
        } else if (s2[0] == s3[0] && s1[0] == s3[0]) {
            return isInterleave(s1.substring(1), s2, s3.substring(1)) ||
                    isInterleave(s1, s2.substring(1), s3.substring(1))
        } else {
            return false
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S97().isInterleave("aabcc", "dbbca", "aadbbbaccc"))
        }
    }
}