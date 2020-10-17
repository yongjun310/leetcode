package com.lc.source.s200

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.min

/*
290. Word Pattern
Easy

1498

191

Add to List

Share
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", s = "dog dog dog dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
Accepted
229,066
Submissions
601,875
 */

class S290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        var strArr = s.split(" ")
        if(pattern.length != strArr.size) {
            return false
        }
        var map = HashMap<Char, String>()
        var map1 = HashMap<String, Char>()
        for(i in pattern.indices) {
            var value = map.get(pattern[i])
            var vc = map1.get(strArr[i])
            if(value != null || vc != null) {
                if(value != null && !value.equals(strArr[i])) {
                    return false
                }
                if(vc != null && vc != pattern[i]) {
                    return false
                }
            } else {
                map.put(pattern[i], strArr[i])
                map1.put(strArr[i], pattern[i])
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