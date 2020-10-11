package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1576. Replace All ?'s to Avoid Consecutive Repeating Characters
Easy

85

70

Add to List

Share
Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.

It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.

Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.



Example 1:

Input: s = "?zs"
Output: "azs"
Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
Example 2:

Input: s = "ubv?w"
Output: "ubvaw"
Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
Example 3:

Input: s = "j?qg??b"
Output: "jaqgacb"
Example 4:

Input: s = "??yw?ipkj?"
Output: "acywaipkja"


Constraints:

1 <= s.length <= 100
s contains only lower case English letters and '?'.
Accepted
13,207
Submissions
27,572
 */

class S1576 {
    fun modifyString(s: String): String {
        var sb = StringBuilder()
        var last = ' '
        for(i in s.indices) {
            if(s[i] == '?') {
                var c = 'a'
                while(c==last || i+1<s.length && s[i+1] != '?' && c == s[i+1]) {
                    c++
                }
                last = c
                sb.append(c)
            } else {
                last = s[i]
                sb.append(s[i])
            }
        }
        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}