import com.lc.source.s1100.S1160
import java.util.*
import kotlin.collections.HashMap

/*
1189. Maximum Number of Balloons
Easy

343

36

Add to List

Share
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.
Accepted
43,479
Submissions
70,393
*/
class S1189{
    fun maxNumberOfBalloons(text: String): Int {
        var map = HashMap<Char, Int>()
        var b = 0
        var a = 0
        var l = 0
        var o = 0
        var n = 0
        for(i in text.indices) {
            when(text[i]) {
                'b'->b++
                'a'->a++
                'l'->l++
                'o'->o++
                'n'->n++
            }
        }
        l /= 2
        o /= 2
        return Math.min(Math.min(a,b), Math.min(Math.min(l,o), n))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}
