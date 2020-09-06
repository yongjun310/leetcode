package com.lc.source.s1000

import com.lc.source.s900.S965
import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1047. Remove All Adjacent Duplicates In String
Easy

904

73

Add to List

Share
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.



Example 1:

Input: "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".


Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
Accepted
89,797
Submissions
130,012
 */

class S1047 {
    fun removeDuplicates(S: String): String {
        var s = Stack<Char>()
        s.push(S[0])
        for(i in 1..S.length-1) {
            if (s.isEmpty()) {
                s.push(S[i])
            } else {
                if (S[i] == s.peek()) {
                    s.pop()
                } else {
                    s.push(S[i])
                }
            }
        }
        var sb = StringBuilder()
        for(i in 0..s.size-1) {
            sb.append(s[i])
        }
        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1047().removeDuplicates("aaaaaaaaa"))
        }
    }

}