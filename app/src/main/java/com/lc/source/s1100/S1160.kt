package com.lc.source.s1100

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
1160. Find Words That Can Be Formed by Characters
Easy

433

77

Add to List

Share
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.
Accepted
56,416
Submissions
83,773
 */

class S1160 {
    fun countCharacters(words: Array<String>, chars: String): Int {
        var hm = HashMap<Char, Int>()
        for(i in 0..chars.length-1) {
            if(hm.get(chars[i]) != null) {
                hm.put(chars[i], hm.get(chars[i])!! + 1)
            } else {
                hm.put(chars[i], 1)
            }
        }
        var len = 0
        for(i in 0..words.size-1) {
            var chm = hm.clone() as HashMap<Char, Int>
            var exist = true
            for(j in 0..words[i].length-1) {
                var c = chm.get(words[i][j])
                if(c==0 || c==null) {
                    exist = false
                    break
                } else {
                    chm.put(words[i][j], c-1)
                }
            }
            if(exist) {
                len += words[i].length
            }
        }
        return len
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S1160().countCharacters(arrayOf("hello","world","leetcode"), "welldonehoneyr"))
        }
    }

}