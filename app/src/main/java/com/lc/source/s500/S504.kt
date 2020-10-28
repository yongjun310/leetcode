package com.lc.source.s500

import kotlin.collections.ArrayList

/*
504. Base 7
Easy

256

151

Add to List

Share
Given an integer, return its base 7 string representation.

Example 1:

Input: 100
Output: "202"
Example 2:

Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].

Accepted
58,696
Submissions
126,625
 */

class S504{
    fun convertToBase7(num: Int): String {
        var sb = StringBuilder()
        var m = num
        var menu = m<0
        if(menu) {
            m = -m
        }
        if(m==0) {
            sb.append(0)
        }
        while(m != 0) {
            sb.insert(0, m%7)
            m /= 7
        }
        if(menu) {
            sb.insert(0, '-')
        }
        return sb.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}