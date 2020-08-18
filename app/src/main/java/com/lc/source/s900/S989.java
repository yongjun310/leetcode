package com.lc.source.s900;

import java.util.ArrayList;
import java.util.List;

public class S989 {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        int e= 0;
        List<Integer> ret = new ArrayList();
        int i=A.length-1;
        while(K>0 && i>=0) {
            int tmp = K%10 + A[i] + e;
            if(tmp>=10) {
                e = 1;
                tmp = tmp - 10;
            } else {
                e = 0;
            }
            K = K/10;
            i--;
            ret.add(0, tmp);
        }
        while(K>0) {
            int tmp = K%10 + e;
            if(tmp>=10) {
                e = 1;
                tmp = tmp - 10;
            } else {
                e = 0;
            }
            K = K/10;
            ret.add(0, tmp);
        }
        while(i>=0) {
            int tmp = A[i] + e;
            if(tmp>=10) {
                e = 1;
                tmp = tmp - 10;
            } else {
                e = 0;
            }
            i--;
            ret.add(0, tmp);
        }
        if(e == 1) {
            ret.add(0, 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] test = {9,2,3,4};
        List<Integer> res = addToArrayForm(test,835);
        for(int i:res) {
            System.out.print(" " +i);
        }
    }
}
