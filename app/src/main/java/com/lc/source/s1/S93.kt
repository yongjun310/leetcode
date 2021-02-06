package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/*
93. Restore IP Addresses
Medium

1623

545

Add to List

Share
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.



Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


Constraints:

0 <= s.length <= 3000
s consists of digits only.
Accepted
224,089
Submissions
599,181
 */

class S93{
    fun restoreIpAddresses(s: String): List<String> {
        var list = ArrayList<String>()
        helper(s, 0, StringBuilder(), 0, list)
        return list
    }

    fun helper(s: String, index:Int, sb: StringBuilder, dotnum: Int, list:ArrayList<String>) {
        var substr = s.substring(index)
        if (dotnum == 3) {
            if (substr.length>3) {
                return
            }
            var intValue = Integer.parseInt(substr)
            if (substr.length == 3 && (intValue > 255 || intValue < 100) ||
                            substr.length == 2 && (intValue < 10)) {
                return
            }
            sb.append('.').append(substr)
            list.add(sb.toString())
        } else if (substr.length>=4-dotnum) {
            if (dotnum != 0) {
                sb.append('.')
            }
            helper(s, index+1, StringBuilder(sb).append(s[index]), dotnum+1, list)
            if (index+2<s.length && s[index] != '0') {
                helper(s, index+2, StringBuilder(sb).append(s.substring(index,index+2)), dotnum+1, list)
            }
            if (index+3<s.length && s[index] != '0' && Integer.parseInt(s.substring(index, index+3))<=255) {
                helper(s, index+3, StringBuilder(sb).append(s.substring(index, index+3)), dotnum+1, list)
            }
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S93().restoreIpAddresses("010010"))
        }
    }
}