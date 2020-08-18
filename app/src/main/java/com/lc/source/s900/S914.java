package com.lc.source.s900;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class S914 {
    public static boolean hasGroupsSizeX(int[] deck) {
        if(deck.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < deck.length; i++) {
            if(map.get(deck[i]) != null) {
                map.put(deck[i], map.get(deck[i]) + 1);
            } else {
                map.put(deck[i], 1);
            }
        }
        int minE = -1;
        Collection<Integer> values = map.values();
        for (Integer v : values) {
            if (v >=3 && v%2 != 0 &&  (v<minE || minE == -1) ) {
                minE = v;
            }
            if(v == 1) {
                return false;
            }
        }
        List<Integer> div = new ArrayList<>();
        if(minE != -1) {
            for(int i = 2; i<=minE; i++) {
                if(minE % i == 0) {
                    div.add(i);
                }
            }
        }
        if(div.size() == 0) {
            div.add(minE == -1?2:minE);
        }
        for (Integer v : values) {
            boolean ret = false;
            for(int i:div) {
                if(v % i == 0) {
                    ret = true;
                }
            }
            if(!ret) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = {1,1,2,2,3,3};
        boolean b = hasGroupsSizeX(test);
        System.out.print(" " + b);
    }
}
