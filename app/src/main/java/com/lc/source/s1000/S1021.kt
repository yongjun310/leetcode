package com.lc.source.s1000

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1021. Remove Outermost Parentheses
Easy

540

656

Add to List

Share
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.



Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation:
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: "()()"
Output: ""
Explanation:
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".


Note:

S.length <= 10000
S[i] is "(" or ")"
S is a valid parentheses string

Accepted
98,800
Submissions
126,189
 */

class S1021 {
    fun removeOuterParentheses(S: String): String {
        var q = StringBuilder()
        var c = 0
        for(i in 0..S.length-1) {
            if(c>1 || c==1 && S[i] != ')' ) {
                q.append(S[i])
            }
            if(S[i] == '(') {
                c++
            } else {
                c--
            }
        }
        return q.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1021().removeOuterParentheses("(()())(())(()(()))"))
        }
    }

}