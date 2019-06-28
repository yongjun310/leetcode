package com.leetcode.source.s100;

import java.util.ArrayList;
import java.util.List;

public class S118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> row;
        for(int i=1; i<=numRows; i++) {
            row = new ArrayList<>();
            for(int j=0; j<i; j++) {
                if(i<3 || j==0 || j == i-1) {
                    row.add(1);
                } else {
                    row.add(ret.get(i-2).get(j-1) + ret.get(i-2).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(0);

        for(List<Integer> i : res) {
            for(Integer j:i) {
                System.out.print(" " + j);
            }
            System.out.println();
        }

    }
}
