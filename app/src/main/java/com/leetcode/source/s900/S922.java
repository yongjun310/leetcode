package com.leetcode.source.s900;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class S922 {
    public static int[] sortArrayByParityII(int[] A) {
        int s = 0, e = A.length-1;
        while(true) {
            while(s<A.length-1 && A[s]%2==0){
                s = s + 2;
            }
            while(e>=1 && A[e]%2!=0){
                e = e-2;
            }
            if(s == A.length) {
                return A;
            }
            int tmp = A[s];
            A[s] = A[e];
            A[e] = tmp;
            s = s + 2;
            e = e-2;
            if(s == A.length) {
                return A;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {2,3};
        int[] res = sortArrayByParityII(test);
        for(int i=0; i<res.length;i++) {
            System.out.print(" " + res[i]);
        }
    }
}
