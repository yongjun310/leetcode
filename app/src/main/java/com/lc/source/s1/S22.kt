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
        var list = HashSet<String>()
        var sublist = generateParenthesis(n-1)
        for (i in sublist.indices) {
            for (j in sublist[i].indices) {
                var sb = StringBuilder(sublist[i])
                sb.insert(j, "()")
                list.add(sb.toString())
            }
            var str = "(" + sublist[i] + ")"
            list.add(str)
        }
        return list.toList()
    }

    //["((((()))))","(((()())))","(((())()))","(((()))())","(((())))()","((()(())))","((()()()))","((()())())","((()()))()","((())(()))","((())()())","((())())()","((()))(())","((()))()()","(()((())))","(()(()()))","(()(())())","(()(()))()","(()()(()))","(()()()())","(()()())()","(()())(())","(()())()()","(())((()))","(())(()())","(())(())()","(())()(())","(())()()()","()(((())))","()((()()))","()((())())","()((()))()","()(()(()))","()(()()())","()(()())()","()(())(())","()(())()()","()()((()))","()()(()())","()()(())()","()()()(())","()()()()()"]
    //  ()()()()() (())()()() ()(())()() ()()(())() ()()()(()) (()()()()) (()())()() ((()))()() (())(())() (())()(()) ((())()()) ()(()())() ()((()))() ()(())(()) (()(())()) ()()(()()) ()()((())) (()()(())) ()(()()()) ((()()())) (()()())() ((())())() (()(()))() (()())(()) ((()())()) ((()()))() (((())))() ((()))(()) (((()))()) (())(()()) (())((())) ((())(())) ()((())()) (((())())) ()(()(())) (()(()())) ()((()())) ()(((()))) (()((()))) ((()(()))) (((()()))) ((((())))) ((((())))) ((((())))) ((((())))) ((((()))))

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