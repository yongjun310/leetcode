package com.lc.source.s600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S697 {
    public static int findShortestSubArray(int[] nums) {
        int[] tmp = new int[nums.length];
        for(int i=0;i<nums.length; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        int cur = tmp[0];
        int max = 1;
        List<Integer> same = new ArrayList();
        same.add(cur);
        int count = 1;
        for(int i=1;i<tmp.length; i++) {
            if(tmp[i] == cur) {
                count++;
            } else {
                if(max < count) {
                    max = count;
                    same.clear();
                    same.add(cur);
                } else if(max == count) {
                    same.add(cur);
                }
                cur = tmp[i];
                count = 1;
            }
        }
        if(max < count) {
            max = count;
            same.clear();
            same.add(cur);
        } else if(max == count) {
            same.add(cur);
        }
        int shortest = Integer.MAX_VALUE;
        for(int tar:same) {
            int begin=-1;
            int curMax = max;
            for(int i=0;i<nums.length; i++) {
                if(tar == nums[i]) {
                    if(begin == -1) {
                        begin = i;
                    }
                    if(--curMax<=0) {
                        int len = i-begin+1;
                        if(len<shortest) {
                            shortest = len;
                        }
                        curMax = max;
                    }
                }
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        int[] test = {1,1};
        int b = findShortestSubArray(test);
        System.out.print(" " + b);
    }
}
