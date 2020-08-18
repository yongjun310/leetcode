package com.lc.source.s1000;

import java.util.ArrayList;
import java.util.List;

/*Given an array A of strings made only from lowercase letters, return a list of all characters
that show up in all strings within the list (including duplicates).
For example, if a character occurs 3 times in all strings but not 4 times,
 you need to include that character three times in the final answer.

You may return the answer in any order.



Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]


Note:

1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] is a lowercase letter*/
public class S1002 {
    public static List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        char s = 'a';
        while(s<='z') {
            int minCount = Integer.MAX_VALUE;
            for(int i=0;i<A.length;i++) {
                int c = countOfChar(A[i], s);
                if(c<minCount) {
                    minCount = c;
                }
            }
            while(minCount-->0) {
                ret.add(String.valueOf(s));
            }
            s++;
        }
        return ret;
    }

    public static int countOfChar(String a, char b) {
        int count = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i) == b) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] a = {"cool","lock","cook"};

        List<String> b = commonChars(a);
        for(String i:b) {
            System.out.print(" " + i);
        }
    }
}
