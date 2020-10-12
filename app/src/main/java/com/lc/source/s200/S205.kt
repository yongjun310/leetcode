package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
205. Isomorphic Strings
Easy

1592

393

Add to List

Share
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.

Accepted
316,339
Submissions
790,225
 */

class S205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        for(i in s.indices) {
            if(s.indexOf(s[i]) != t.indexOf(t[i])) {
                return false
            }
        }
        return true
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}