package com.lc.source.s500

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
500. Keyboard Row
Easy

581

710

Add to List

Share
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.






Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]


Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
Accepted
117,174
Submissions
179,802
 */

class S500{
    fun findWords(words: Array<String>): Array<String> {
        var lowarr = arrayOf("qwertyuiopQWERTYUIOP", "asdfghjklASDFGHJKL","zxcvbnmZXCVBNM")
        var ret = ArrayList<String>()
        for(e in words) {
            var has = true
            var i = -1
            for(c in e) {
                if(i>=0) {
                    if(!lowarr[i].contains(c)){
                        has = false
                        break
                    }

                } else {
                    for(j in 0 until lowarr.size) {
                        if(lowarr[j].contains(c)) {
                            i = j
                            break
                        }
                    }
                }
            }
            if(has) {
                ret.add(e)
            }
        }
        return ret.toTypedArray()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S500().findWords(arrayOf("Peace","Alaska","Dad","Peace")))
        }
    }
}