import com.lc.source.s1100.S1160
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
1309. Decrypt String from Alphabet to Integer Mapping
Easy

379

41

Add to List

Share
Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.



Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
Example 3:

Input: s = "25#"
Output: "y"
Example 4:

Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"


Constraints:

1 <= s.length <= 1000
s[i] only contains digits letters ('0'-'9') and '#' letter.
s will be valid string such that mapping is always possible.
Accepted
39,975
Submissions
51,806
*/
class S1309{
    fun freqAlphabets(s: String): String {
        var sb = StringBuilder()
        var i = 0
        while(i < s.length) {
            if (i + 2 < s.length) {
                if (s[i + 2] != '#') {
                    sb.append('a' + (s[i] - '1'))
                    i++
                } else {
                    sb.append('j' + (s[i] - '1') * 10 + (s[i + 1] - '0'))
                    i += 3
                }
            } else if (i < s.length) {
                sb.append('a' + (s[i] - '1'))
                i++
            }
        }
        return sb.toString()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
