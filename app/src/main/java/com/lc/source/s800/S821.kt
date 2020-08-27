package com.lc.source.s800

import java.lang.StringBuilder

/*
821. Shortest Distance to a Character
Easy

1116

78

Add to List

Share
Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]


Note:

S string length is in [1, 10000].
C is a single character, and guaranteed to be in string S.
All letters in S and C are lowercase.
Accepted
68,276
Submissions
101,846
 */

class S821 {
    fun shortestToChar(S: String, C: Char): IntArray {
        var earray = ArrayList<Int>()
        for (i in 0 .. S.length-1) {
            if(S[i] == C) {
                earray.add(i)
            }
        }
        var lastei = -1
        var nextei = earray[0]
        var ei = 0
        var array = IntArray(S.length)
        for (i in 0 .. S.length-1) {
            if(i<nextei) {
                if(lastei == -1) {
                    array[i] = nextei - i
                } else {
                    array[i] = Math.min(nextei-i, i-lastei)
                }
            } else if(i==nextei) {
                array[i] = 0
            } else {
                if(ei<earray.size-1) {
                    ei++
                    lastei = nextei
                    nextei = earray[ei]
                } else {
                    if(nextei != -1) {
                        lastei = nextei
                    }
                    nextei = -1
                }
                if(nextei == -1) {
                    array[i] = i - lastei
                } else {
                    array[i] = Math.min(nextei-i, i-lastei)
                }
            }

        }
        return array
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S821().shortestToChar("abaa", 'b'))
        }
    }

}