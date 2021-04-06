package com.lc.source.s100

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/*
187. Repeated DNA Sequences
Medium

1167

333

Add to List

Share
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule. You may return the answer in any order.



Example 1:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:

Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]


Constraints:

1 <= s.length <= 105
s[i] is either 'A', 'C', 'G', or 'T'.
Accepted
206,158
Submissions
494,952
 */

class S187 {
    fun findRepeatedDnaSequences(s: String): List<String> {
        var retSet = HashSet<String>()
        var retList = HashSet<String>()
        for (i in 0 .. s.length-10) {
            var str = s.substring(i, i+10)
            if (!retSet.add(str)) {
                retList.add(str)
            }
        }
        return retList.toList()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S187().findRepeatedDnaSequences("AAAAAAAAAAA"))
        }
    }
}
