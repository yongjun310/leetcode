package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1078. Occurrences After Bigram
Easy

160

190

Add to List

Share
Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.



Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]


Note:

1 <= text.length <= 1000
text consists of space separated words, where each word consists of lowercase English letters.
1 <= first.length, second.length <= 10
first and second consist of lowercase English letters.
Accepted
31,218
Submissions
48,259
 */

class S1478 {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        var words = text.split(' ')
        var list = ArrayList<String>()
        if(words.size<3) {
            return Array(0, {""})
        }
        for(i in 2..words.size-1) {
            if(words[i-2].equals(first) && words[i-1].equals(second)) {
                list.add(words[i])
            }
        }
        return list.toTypedArray()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}