import com.lc.source.s1100.S1160

/*
1170. Compare Strings by Frequency of the Smallest Character
Easy

269

682

Add to List

Share
Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

 

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 

Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.
Accepted
45,968
Submissions
77,644
*/
class S1170{
    fun frequency(str: String): Int {
        var sc = 'z' + 1
        var c = 0
        for(i in str.indices) {
            if(sc>str[i]) {
                sc = str[i]
            }
        }
        for(element in str) {
            if(sc== element) {
                c++
            }
        }
        return c
    }

    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        var fword = Array(words.size, {0})
        for(i in words.indices) {
            fword[i] = frequency(words[i])
        }
        fword.sort()
        var qword = IntArray(queries.size, {0})
        for(i in queries.indices) {
            var c = words.size
            var fq = frequency(queries[i])
            for(j in words.indices) {
                if(fq>=fword[j]) {
                    c--
                }
            }
            qword[i] = c
        }
        return qword
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            for(element in S1170().numSmallerByFrequency(arrayOf("bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"),
                    arrayOf("aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"))) {
                println(element)
            }
        }
    }
}
