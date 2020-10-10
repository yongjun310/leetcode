package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1544. Make The String Great
Easy

199

25

Add to List

Share
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:

0 <= i <= s.length - 2
s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.



Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"


Constraints:

1 <= s.length <= 100
s contains only lower and upper case English letters.
Accepted
19,427
Submissions
35,471
 */

class S1544 {
    fun makeGood(s: String): String {
        var sb = StringBuilder()
        var hc = true
        var str = s
        while(hc) {
            if(str.length == 1) {
                return str
            }
            var i = 1
            hc = false
            while(i< str.length) {
                if(str[i] - 32 != str[i-1] && str[i-1]-32 != str[i]) {
                    sb.append(str[i-1])
                    if(i==str.length-1) {
                        sb.append(str[i])
                    }
                    i++
                } else {
                    i += 2
                    hc = true
                    if(i==str.length) {
                        sb.append(str[i-1])
                    }
                }
            }
            str = sb.toString()
            sb.clear()
        }
        return str
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1544().makeGood("RLlr"))
        }
    }

}