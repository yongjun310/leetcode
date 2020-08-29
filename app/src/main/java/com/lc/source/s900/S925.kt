package com.lc.source.s900

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/*
925. Long Pressed Name
Easy

688

113

Add to List

Share
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
Example 3:

Input: name = "leelee", typed = "lleeelee"
Output: true
Example 4:

Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.


Constraints:

1 <= name.length <= 1000
1 <= typed.length <= 1000
The characters of name and typed are lowercase letters.
Accepted
47,940
Submissions
119,462
 */

class S925 {
    fun isLongPressedName(name: String, typed: String): Boolean {
        if(name == null){
            return typed == null
        }
        if(name == "") {
            return typed.equals("")
        }
        var lastc = name[0]
        var j=0
        for(i in 0..name.length-1) {
            if(j>typed.length-1) {
                return false
            }
            if(name[i] == typed[j]) {
                j++
                lastc = name[i]
                continue
            } else {
                while (j < typed.length) {
                    if(lastc == typed[j]) {
                        j++
                    } else {
                        break
                    }
                }
                if(j== typed.length) {
                    return false
                } else {
                    if(name[i] == typed[j]){
                        j++
                        lastc = name[i]
                    } else {
                        return false
                    }
                }
            }
        }
        while(j<typed.length) {
            if(lastc == typed[j]) {
                j++
            } else {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S925().isLongPressedName("pyplrz",
                    "ppyypllr"))
        }
    }

}