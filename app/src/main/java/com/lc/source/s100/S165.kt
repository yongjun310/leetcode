package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.math.min

/*
165. Compare Version Numbers
Medium

799

1686

Add to List

Share
Given two version numbers, version1 and version2, compare them.

Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right, with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33 and 0.1 are valid version numbers.

To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

Return the following:

If version1 < version2, return -1.
If version1 > version2, return 1.
Otherwise, return 0.


Example 1:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
Example 2:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
Example 3:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Explanation: version1's revision 0 is "0", while version2's revision 0 is "1". 0 < 1, so version1 < version2.
Example 4:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 5:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1


Constraints:

1 <= version1.length, version2.length <= 500
version1 and version2 only contain digits and '.'.
version1 and version2 are valid version numbers.
All the given revisions in version1 and version2 can be stored in a 32-bit integer.
Accepted
238,608
Submissions
779,945
 */

class S165 {
    fun compareVersion(version1: String, version2: String): Int {
        var v1 = delZero(version1)
        var v2 = delZero(version2)
        var v1arr = v1.split('.')
        var v2arr = v2.split('.')
        var i = 0
        var min = if (v1arr.size>v2arr.size) v2arr.size else v1arr.size
        while (i < min) {
            if (v1arr[i].toInt() > v2arr[i].toInt()) {
                return 1
            } else if (v1arr[i].toInt() < v2arr[i].toInt()) {
                return -1
            }
            i++
        }
        if (v1arr.size != min) {
            for (j in i until v1arr.size) {
                if (v1arr[j].toInt() != 0) {
                    return 1
                }
            }
        } else if (v2arr.size != min) {
            for (j in i until v2arr.size) {
                if (v2arr[j].toInt() != 0) {
                    return -1
                }
            }
        }
        return 0
    }

    fun delZero(s: String) : String {
        var sb = StringBuilder()
        var lastIsPoint = true
        for (i in s.indices) {
            if (s[i] != '0') {
                sb.append(s[i])
                lastIsPoint = s[i] == '.'
            } else {
                if (lastIsPoint) {
                    if (i < s.length-1 && s[i+1] == '.' || i == s.length-1)  {
                        sb.append(s[i])
                    }
                } else {
                    sb.append(s[i])
                }
            }
        }
        return sb.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S165().compareVersion("1.0", "1.0.0"))
        }
    }
}