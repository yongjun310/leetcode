package com.lc.source.s700

/*
771. Jewels and Stones
Easy

2192

373

Add to List

Share
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.
 You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

 */

class S771 {

    fun numJewelsInStones(J: String, S: String): Int {
        var c = 0
        var set = HashSet<Char>()
        for(i in 0..J.length-1) {
            set.add(J[i])
        }
        for(i in 0..S.length-1) {
            if(set.contains(S[i])) {
                c++
            }
        }
        return c
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S771().numJewelsInStones("aA", "aAAbbbb"))
        }
    }

}