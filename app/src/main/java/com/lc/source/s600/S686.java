package com.lc.source.s600;

/**
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.
 * If no such solution, return -1.
 *
 * For example, with A = "abcd" and B = "cdabcdab".
 *
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of
 * A repeated two times ("abcdabcd").
 *
 * Note:
 * The length of A and B will be between 1 and 10000.
 */
public class S686 {
    public static int repeatedStringMatch(String A, String B) {
        String tempS=A;
        int count=1;
        while(A.length()<B.length()){
            A+=tempS;
            count++;
        }
        if(A.indexOf(B)>=0) {
            return count;
        }
        A=A+tempS;
        if(A.indexOf(B)>=0) {
            return count+1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int b = repeatedStringMatch("abc", "cabcabca");

        System.out.print(" " + b);
    }
}
