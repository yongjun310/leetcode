package com.leetcode.source.s100;

public class S125 {
    public static boolean isPalindrome(String s) {
        int sIndex = 0, eIndex = s.length() - 1;
        while(true) {
            if(sIndex >= eIndex) {
                return true;
            }
            char start = s.charAt(sIndex);
            char end = s.charAt(eIndex);
            if(!Character.isLetterOrDigit(start)) {
                sIndex++;
                continue;
            } else if(Character.isLetter(start)){
                start = Character.toLowerCase(start);
            }
            if(!Character.isLetterOrDigit(end)) {
                eIndex--;
                continue;
            } else if(Character.isLetter(end)){
                end = Character.toLowerCase(end);
            }
            if(start != end) {
                return false;
            } else {
                sIndex++;
                eIndex--;
            }
        }
    }

    public static void main(String[] args) {
        boolean res = isPalindrome("0p");
        System.out.println(res);
    }
}
