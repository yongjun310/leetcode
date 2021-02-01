package com.lc.source.s1

import java.lang.StringBuilder
import java.util.*


/*
71. Simplify Path
Medium

1042

2058

Add to List

Share
Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.

In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.

The canonical path should have the following format:

The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
Return the simplified canonical path.



Example 1:

Input: path = "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after the last directory name.
Example 2:

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
Example 4:

Input: path = "/a/./b/../../c/"
Output: "/c"


Constraints:

1 <= path.length <= 3000
path consists of English letters, digits, period '.', slash '/' or '_'.
path is a valid absolute Unix path.
Accepted
241,147
Submissions
715,848
 */

class S71{
    fun simplifyPath(path: String): String {
        var strlist = path.split('/')
        var stack = Stack<String>()
        var sp = StringBuilder("/")
        for (i in strlist.indices) {
            if (strlist[i] != null && strlist[i] != "." && strlist[i] != "") {
                if (strlist[i] != "..") {
                    stack.push(strlist[i])
                } else if (stack.isNotEmpty()) {
                    stack.pop()
                }
            }
        }
        var s2 = Stack<String>()
        while (stack.isNotEmpty()) {
            s2.push(stack.pop())
        }
        while (s2.isNotEmpty()) {
            sp.append(s2.pop())
            if (s2.isNotEmpty()) {
                sp.append("/")
            }
        }
        return sp.toString()
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            print(S71().simplifyPath("/../"))
        }
    }
}