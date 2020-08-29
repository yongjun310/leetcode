package com.lc.source.s900

import java.lang.StringBuilder
import kotlin.collections.HashSet

/*
929. Unique Email Addresses
Easy

903

192

Add to List

Share
Every email consists of a local name and a domain name, separated by the @ sign.

For example, in alice@leetcode.com, alice is the local name, and leetcode.com is the domain name.

Besides lowercase letters, these emails may contain '.'s or '+'s.

If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)

If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)

It is possible to use both of these rules at the same time.

Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?



Example 1:

Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails


Note:

1 <= emails[i].length <= 100
1 <= emails.length <= 100
Each emails[i] contains exactly one '@' character.
All local and domain names are non-empty.
Local names do not start with a '+' character.
Accepted
209,936
Submissions
311,606
 */

class S929 {
    fun numUniqueEmails(emails: Array<String>): Int {
        var eset = HashSet<String>()
        var sb = StringBuilder()
        for(i in 0..emails.size-1) {
            sb.clear()
            var hasps = false
            var haat = false
            for(j in 0..emails[i].length-1) {
                if(emails[i][j] == '.') {
                    continue
                } else if( emails[i][j] == '+' || emails[i][j] == '@') {
                    break;
                } else {
                    sb.append(emails[i][j])
                }
            }
            sb.append(emails[i].substring(emails[i].indexOf('@')))
            eset.add(sb.toString())
        }
        return eset.size
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(S929().numUniqueEmails(arrayOf("test.email+alex@leetcode.com", "test.email@leetcode.com")))
        }
    }

}