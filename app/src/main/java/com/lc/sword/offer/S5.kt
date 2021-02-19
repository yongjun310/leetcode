package com.lc.sword.offer

import java.lang.StringBuilder
import java.util.*
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

 

示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."
 

限制：

0 <= s 的长度 <= 10000

通过次数144,266提交次数189,332

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class S5 {
    fun replaceSpace(s: String): String {
        var last = 0
        var sb = StringBuilder()
        for (i in s.indices) {
            if (s[i] == ' ') {
                sb.append(s.substring(last, i))
                sb.append("%20")
                last = i+1
            }
        }
        if (last<s.length) {
            sb.append(s.substring(last, s.length))
        }
        return sb.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S5().replaceSpace(""))
//            print(S4().findNumberIn2DArray(arrayOf(intArrayOf(1,   4), intArrayOf(2,   5)), 0))
        }
    }
}