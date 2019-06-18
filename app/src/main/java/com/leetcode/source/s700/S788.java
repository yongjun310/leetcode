package com.leetcode.source.s700;

import java.util.ArrayList;
import java.util.List;

public class S788 {
    public static int rotatedDigits(int N) {
        int res = 0;
        List<Integer> rl = new ArrayList<>();
        rl.add(1);
        rl.add(2);
        rl.add(5);
        rl.add(6);
        rl.add(8);
        rl.add(9);
        rl.add(0);
        List<Integer> rl18 = new ArrayList<>();
        rl18.add(1);
        rl18.add(8);
        rl18.add(0);
        for(int i=1; i<=N; i++) {
            int j = i;
            boolean isr = false;
            boolean is18 = true;
            while(j>0) {
                int tmp = j%10;
                if(is18) {
                    is18 = rl18.contains(tmp);
                }
                if(!rl.contains(tmp)) {
                    break;
                } else {
                    j = j/10;
                }
            }
            if(j==0) {
                isr = true;
            }
            if(isr && !is18) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int test = 857;
        int res = rotatedDigits(test);
        System.out.print(" " + res);
    }
}
