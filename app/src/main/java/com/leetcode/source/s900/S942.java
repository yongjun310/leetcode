package com.leetcode.source.s900;

/**
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
 *
 * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
 *
 * If S[i] == "I", then A[i] < A[i+1]
 * If S[i] == "D", then A[i] > A[i+1]
 *
 *
 * Example 1:
 *
 * Input: "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: "DDI"
 * Output: [3,2,0,1]
 *
 *
 * Note:
 *
 * 1 <= S.length <= 10000
 * S only contains characters "I" or "D".
 */
public class S942 {
    public static int[] diStringMatch(String S) {
        int[] ret = new int[S.length()+1];
        int dnum = S.length();
        for(int i=0;i<S.length();i++) {
            if(S.charAt(i) == 'I') {
                ret[i] = i - S.length() + dnum;
                if(i+1==S.length()) {
                    ret[i+1] = i+1 - S.length() + dnum;
                }
            } else {
                ret[i] = dnum--;
                if(i+1==S.length()) {
                    ret[i+1] = dnum;
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] b = diStringMatch("IDID");
        for(int a:b) {
            System.out.print(" " + a);
        }
    }
}
