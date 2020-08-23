package com.lc.source.s700

/*
744. Find Smallest Letter Greater Than Target
Add to List
Share
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 */

class S744 {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var eqchar = target
        if(eqchar >= letters[letters.size-1]) {
            eqchar = letters[0]
        } else {
            eqchar++
        }
        var s = 0
        var e = letters.size
        while(s<e) {
            var m = (s+e)/2
            if(letters[m] < eqchar) {
                s = m+1
            } else if(letters[m] >= eqchar) {
                if(m-1<0) {
                    return letters[m]
                } else {
                    if(letters[m-1] < eqchar) {
                        return letters[m]
                    } else {
                        e = m
                    }
                }
            }
        }
        return ' '
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var input = CharArray(3)
            input[0] = 'c'
            input[1] = 'f'
            input[2] = 'j'
            print(S744().nextGreatestLetter(input, 'a'))
        }
    }

}