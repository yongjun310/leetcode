package com.lc.source.s700

/*
796. Rotate String
Easy

774

53

Add to List

Share
We are given two strings, A and B.

A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
Note:

A and B will have length at most 100.

 */

class S796 {
    fun rotateString(A: String, B: String): Boolean {
        var len = A.length
        if(A==null || B==null || A.length != B.length) {
            return false
        }
        if(A.equals(B)) {
            return true
        }
        var i = 0
        while (i>=0 && i<len) {
            i = B.indexOf(A[0], i)
            if(i>0 && A.substring(0, len-i).equals(B.substring(i, len)) && A.substring(len-i, len).equals(B.substring(0, i))) {
                return true
            } else {
                if(i<0) {
                    return false
                }
                i++
            }
        }
        return false
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S796().rotateString("abcde", "abced"))
        }
    }

}