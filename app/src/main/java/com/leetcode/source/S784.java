package com.leetcode.source;

import java.util.ArrayList;
import java.util.List;

public class S784 {
    public static List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        ret.add(S);
        for(int i=0; i<S.length(); i++) {
            char t = S.charAt(i);
            if(t<9 && t<0) {
                continue;
            }
            char st;
            if(t <='Z') {
                st = (char)(t+32);
            } else {
                st = (char)(t-32);
            }
            List<String> ret1 = new ArrayList<>();
            ret1.addAll(ret);
            for(String s: ret1) {
                StringBuilder sb = new StringBuilder();
                if(i-1 > 0) {
                    sb.append(S.substring(0, i - 1));
                }
                sb.append(st);
                if(i+1<S.length()-1) {
                    sb.append(S.substring(i+1));
                }
                ret.add(sb.toString());
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String test = "a1b2";
        List<String> res = letterCasePermutation(test);
        for(String s:res) {
            System.out.print(" " + s);
        }
    }
}
