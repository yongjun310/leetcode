package com.lc.source.s800

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
884. Uncommon Words from Two Sentences
Easy

463

90

Add to List

Share
We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]


Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.
Accepted
58,621
Submissions
92,437
 */

class S884 {

    fun uncommonFromSentences(A: String, B: String): Array<out Any>? {
        var astrs = A.split(" ")
        var bstrs = B.split(" ")
        var arset = HashSet<String>()
        var brset = HashSet<String>()
        var aset = HashSet<String>()
        var bset = HashSet<String>()
        for(s in astrs) {
            if(aset.contains(s)){
                aset.remove(s)
                arset.add(s)
            } else if(!arset.contains(s)){
                aset.add(s)
            }
        }
        for(s in bstrs) {
            if(bset.contains(s)){
                bset.remove(s)
                brset.add(s)
            } else if(!brset.contains(s)){
                bset.add(s)
            }
        }
        var iterator = aset.iterator()
        while(iterator.hasNext()) {
            var s = iterator.next()
            if(bset.contains(s)) {
                iterator.remove()
                bset.remove(s)
            }
        }
        aset.addAll(bset)
        aset.removeAll(arset)
        aset.removeAll(brset)
        return aset.toArray()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S884().uncommonFromSentences("this apple is sweet",
                    "this apple is sour"))
        }
    }

}