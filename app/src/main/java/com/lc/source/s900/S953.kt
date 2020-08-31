package com.lc.source.s900

import java.lang.StringBuilder
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashSet

/*
953. Verifying an Alien Dictionary
Easy

957

391

Add to List

Share
In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
All characters in words[i] and order are English lowercase letters.
Accepted
133,652
Submissions
247,956
 */

class S953 {
    fun compare(str1: String, str2: String, order: String) : Int{
        var len1 = str1.length
        var len2 = str2.length
        var len = Math.min(len1, len2)
        for(i in 0..len-1) {
            var in1 = order.indexOf(str1[i])
            var in2 = order.indexOf(str2[i])
            if(in1 != in2) {
                return in1-in2
            }
        }
        return len1-len2

    }

    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        for(i in 1..words.size-1) {
            if(compare(words[i-1], words[i], order) > 0) {
                return false
            }
        }
        return true
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }

}