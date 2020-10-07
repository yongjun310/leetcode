package com.lc.source.s1400

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
1408. String Matching in an Array
Easy

203

49

Add to List

Share
Given an array of string words. Return all strings in words which is substring of another word in any order.

String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].



Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:

Input: words = ["blue","green","bu"]
Output: []


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.
Accepted
27,247
Submissions
43,507
 */

class S1408 {
    fun stringMatching(words: Array<String>): List<String> {
        var rl = ArrayList<String>()
        for(i in 0..words.size-1) {
            for(j in 0..words.size-1) {
                if(i != j && words[j].contains(words[i])) {
                    rl.add(words[i])
                    break
                }
            }
        }
        return rl
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}