package com.lc.source.s1

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
49. Group Anagrams
Medium

4812

218

Add to List

Share
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lower-case English letters.
Accepted
840,860
Submissions
1,425,479
 */

class S49{
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        var map = HashMap<String, Int>()
        var cur = 0
        var retList = ArrayList<ArrayList<String>>()
        for (i in strs.indices) {
            var ca = strs[i].toCharArray()
            ca.sort()
            var index = map.get(String(ca))
            if (index == null) {
                map.put(String(ca), cur)
                var list = ArrayList<String>()
                list.add(strs[i])
                retList.add(list)
                cur++
            } else {
                retList[index].add(strs[i])
            }
        }
        return retList
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S49().groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
        }
    }
}