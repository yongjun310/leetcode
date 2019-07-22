package com.leetcode.source.s1;

public class S14 {
    public static String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String mins = "";
        if(strs.length == 0) {
            return "";
        }
        if(strs.length == 1) {
            return strs[0];
        }
        for(String b:strs) {
            if(b.length() < min) {
                min = b.length();
                mins = b;
            }
        }
        if(min == 0) {
            return "";
        }
        int s = 0, e = min-1;
        String rpre = "";
        while(s<e) {
            int mid = (s+e)/2;
            String pre = mins.substring(0, mid);
            boolean ok = true;
            for(String b:strs) {
                if(!b.startsWith(pre)) {
                    e = mid-1;
                    ok = false;
                    break;
                }
            }
            if(ok) {
                rpre = pre;
            }
            s = mid + 1;
        }
        return rpre;
    }


    public static void main(String[] args) {
        String[] a = {"fliower","fliow","flight"};

        String b = longestCommonPrefix(a);

        System.out.print(" " + b);
    }
}
