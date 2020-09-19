package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1446. Consecutive Characters
Easy

207

5

Add to List

Share
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.

Return the power of the string.



Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
Example 3:

Input: s = "triplepillooooow"
Output: 5
Example 4:

Input: s = "hooraaaaaaaaaaay"
Output: 11
Example 5:

Input: s = "tourist"
Output: 1


Constraints:

1 <= s.length <= 500
s contains only lowercase English letters.
Accepted
23,038
Submissions
37,974
 */

class S1446 {
    fun maxPower(s: String): Int {
        var maxPower = 1
        var curPower = 1
        var lastChar = s[0]
        for(i in 1..s.length-1) {
            if(s[i] == lastChar) {
                curPower++
                if(curPower>maxPower) {
                    maxPower = curPower
                }
            } else {
                curPower = 1
                lastChar = s[i]
            }
        }
        return maxPower
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}