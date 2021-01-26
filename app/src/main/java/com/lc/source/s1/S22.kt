package com.lc.source.s1

import java.lang.StringBuilder
import kotlin.collections.ArrayList

/*
22. Generate Parentheses
Medium

6937

310

Add to List

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
Accepted
672,523
Submissions
1,035,977
 */

class S22{
    fun generateParenthesis(n: Int): List<String> {
        if (n == 1) {
            return listOf("()")
        }
        var sb = StringBuilder()
        var list = ArrayList<String>()
        helper(sb, 0, 0, n, list)
        return list.toList()
    }


    fun helper(sb: StringBuilder, left: Int, right: Int, n: Int, list:ArrayList<String>) {
        if (left == n && right == n) {
            list.add(sb.toString())
        }
        if (left < n) {
            var lsb = StringBuilder(sb)
            lsb.append('(')
            helper(lsb, left+1, right, n, list)
        }
        if (right < n && left>=right+1) {
            var rsb = StringBuilder(sb)
            rsb.append(')')
            helper(rsb, left, right+1, n, list)
        }
    }
    //["()()()()()","(()()()())","()(()()())","(()()())()","((()()()))","()()(()())","()(()())()","(()(()()))","(()())()()","((()())())","()((()()))","((()()))()","(((()())))","()()()(())","()()(())()","(()()(()))","()(())()()","(()(())())","()(()(()))","(()(()))()","((()(())))","(())()()()","((())()())","()((())())","((())())()","(((())()))","()()((()))","()((()))()","(()((())))","((()))()()","(((()))())","()(((())))","(((())))()","((((()))))","()(())(())","(())(())()","((())(()))"]
    //((((())))) (((()()))) (((())())) (((()))()) (((())))() ((()(()))) ((()()())) ((()())()) ((()()))() ((())(())) ((())()()) ((())())() ((()))(()) ((()))()() (()((()))) (()(()())) (()(())()) (()(()))() (()()(())) (()()()()) (()()())() (()())(()) (()())()() (())((())) (())(()()) (())(())() (())()(()) (())()()() ()(((()))) ()((()())) ()((())()) ()((()))() ()(()(())) ()(()()()) ()(()())() ()(())(()) ()(())()() ()()((())) ()()(()()) ()()(())() ()()()(()) ()()()()()
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var s = S22().generateParenthesis(5)
            for (a in s) {
                print(a + " ")
            }
        }
    }
}