package com.leetcode.source;

import java.util.ArrayList;
import java.util.List;

public class S784 {
    public static List<String> letterCasePermutation(String S) {
        List<String> ret = new ArrayList<>();
        ret.add(S);
        for(int i=0; i<S.length(); i++) {
            char t = S.charAt(i);
            if(t<='9' && t>='0') {
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
                sb.append(s.substring(0, i));
                sb.append(st);
                sb.append(s.substring(i+1));
                ret.add(sb.toString());
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String test = "a1b234Eg6P";
        List<String> res = letterCasePermutation(test);
        for(String s:res) {
            System.out.print(" " + s);
        }
    }
}
