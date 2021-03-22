package com.lc.source.s100

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

/*
139. Word Break
Medium

6215

291

Add to List

Share
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
Accepted
726,936
Submissions
1,738,983
 */

class S139 {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        var set = HashSet<String>()
        for (e in wordDict) {
            set.add(e)
        }
        var flagArr = BooleanArray(s.length+1)
        flagArr[0] = true
        for (i in 1..s.length) {
            for (j in 0 until i) {
                var cur = s.substring(j, i)
                if (flagArr[j] && set.contains(cur)) {
                    flagArr[i] = true
                }
            }
        }
        return flagArr[s.length]
    }


    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var s = "leetcode"
            var arr = listOf("leet","code")
            print(S139().wordBreak(s, arr))
        }
    }
}