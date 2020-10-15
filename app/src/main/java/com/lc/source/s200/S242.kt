package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.HashMap
import kotlin.math.min

/*
242. Valid Anagram
Easy

1882

150

Add to List

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Accepted
646,854
Submissions
1,126,139
 */

class S242 {
    fun isAnagram(s: String, t: String): Boolean {
        var ca1 = s.toCharArray()
        var ca2 = t.toCharArray()
        if(s.length != t.length) {
            return false
        }
        ca1.sort()
        ca2.sort()
        for(i in s.indices) {
           if(ca1[i] != ca2[i]) {
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