package com.lc.source.s800

import java.lang.StringBuilder
import java.util.*

/*
844. Backspace String Compare
Easy

1801

92

Add to List

Share
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
Accepted
229,879
Submissions
494,777
 */

class S844 {
    fun backspaceCompare(S: String, T: String): Boolean {
        var s = Stack<Char>()
        for(i in 0..S.length-1) {
            if(S[i] != '#') {
                s.push(S[i])
            } else if(s.isNotEmpty()) {
                s.pop()
            }
        }
        var i = T.length-1
        var a = 0
        while(i>=0) {
            if(T[i] != '#') {
                if(a>0) {
                    a--
                    i--
                    continue
                }
                if(s.isEmpty() || s.pop() != T[i]) {
                    return false
                }
            } else {
                a++
            }
            i--
        }
        if(s.isEmpty()) {
            return true
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S844().backspaceCompare("aaa###a",
                    "aaaa###a"))
        }
    }

}