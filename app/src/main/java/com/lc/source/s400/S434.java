package com.lc.source.s400;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 *
 * Input: "Hello, my name is John"
 * Output: 5
 */
public class S434 {
    public static int countSegments(String s)  {
        if(s == null || "".equals(s)) {
            return 0;
        }
        String[] seg = s.split(" ");
        int count = 0;
        for(String str:seg) {
            if(!" ".equals(str) && str.length() > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int b = countSegments(", , , ,        a, eaefa");

        System.out.print(" " + b);
    }
}
