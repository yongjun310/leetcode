package com.lc.source.s900

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
917. Reverse Only Letters
Easy

606

35

Add to List

Share
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.



Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"


Note:

S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "
Accepted
60,633
Submissions
104,561
 */

class S917 {
    fun reverseOnlyLetters(S: String): String {
        var arr = S.toCharArray()
        var s = 0
        var e = S.length-1
        while(s<e) {
            while(s<=S.length-1 && !S[s].isLetter()) {
                s++
            }
            while(e>=0 && !S[e].isLetter()) {
                e--
            }
            if(s>S.length-1 || e<0) {
                break
            }
            var tm = S[s]
            arr[s] = S[e]
            arr[e] = tm
            s++
            e--
        }
        return String(arr)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S917().reverseOnlyLetters("7_28]"))
        }
    }

}