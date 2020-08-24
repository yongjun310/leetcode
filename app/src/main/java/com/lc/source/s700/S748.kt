package com.lc.source.s700

/*
748. Shortest Completing Word
Easy

184

640

Add to List

Share
Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 */

class S748 {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        var s = ""
        s = licensePlate.replace(Regex("\\d"), "")
        s = s.replace(" ", "")
        var newS = s.toLowerCase().toCharArray()
        newS.sort()
        s = String(newS)
        var len = 15
        var ret = ""
        for(w in words) {
            var ns = w.replace(Regex("[^$s]"), "")
            var ca =  ns.toCharArray()
            ca.sort()
            if(contain(ca, newS) && len > w.length){
                ret = w
                len = w.length
            }
        }
        return ret
    }

    private fun contain(ca: CharArray, newS: CharArray): Boolean {
        var cs = 0
        var ns = 0
        while(cs < ca.size && ns < newS.size) {
            if(ca[cs] < newS[ns]) {
                cs++
            } else if(ca[cs] > newS[ns]) {
                return false
            } else {
                cs++
                ns++
            }
        }
        return ns == newS.size
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var input = "sBt8154"
            var p = arrayOf("night","establish","better","evening","size","watch","however","do","many","move")
            print(S748().shortestCompletingWord(input, p))
        }
    }

}