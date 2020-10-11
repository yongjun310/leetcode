package com.lc.source.s1500

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1592. Rearrange Spaces Between Words
Easy

63

81

Add to List

Share
You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.



Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
Example 3:

Input: text = "hello   world"
Output: "hello   world"
Example 4:

Input: text = "  walks  udp package   into  bar a"
Output: "walks  udp  package  into  bar  a "
Example 5:

Input: text = "a"
Output: "a"


Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.
Accepted
11,227
Submissions
25,593
 */

class S1592 {
    fun reorderSpaces(text: String): String {
        var c = 0
        var last = ' '
        var cw = 0
        for(i in text.indices) {
            if(last == ' ' && text[i] != ' ') {
                cw++
            }
            last = text[i]
            if(text[i] == ' ') {
                c++
            }
        }
        var es = c/(cw-1)
        var ssb = StringBuilder()
        for(i in 0 until es) {
            ssb.append(' ')
        }
        var spstr = ssb.toString()
        var os = c%(cw-1)
        var sb = StringBuilder()
        last = ' '
        var curw = 1
        for(i in text.indices) {
            if(text[i] != ' ') {
                sb.append(text[i])
            }
            if(last != ' ' && text[i] == ' ' && curw<cw) {
                curw++
                sb.append(spstr)
            }
            last = text[i]
        }
        for(i in 0 until os) {
            sb.append(' ')
        }
        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1592().reorderSpaces("  walks  udp package   into  bar a"))
        }
    }

}