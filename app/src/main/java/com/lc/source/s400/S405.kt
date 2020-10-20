package com.lc.source.s400

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.ConcurrentLinkedQueue
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet
import kotlin.math.min

/*
405. Convert a Number to Hexadecimal
Easy

502

120

Add to List

Share
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"
Accepted
71,433
Submissions
161,823
 */

class S405{
    fun toHex(num: Int): String {
        if(num==0){
            return "0";
        }
        var m = num
        var hex = "0123456789abcdef"
        var ans= StringBuilder()
        while(m!=0 && ans.length<8){
            ans.append(hex[m and 0xf])
            m = m shr 4
        }
        return  ans.reverse().toString();
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S405().toHex(26))
        }
    }
}